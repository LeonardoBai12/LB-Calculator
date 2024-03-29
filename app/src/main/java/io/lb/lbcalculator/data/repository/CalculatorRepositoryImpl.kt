package io.lb.lbcalculator.data.repository

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.model.CalculatorData
import io.lb.lbcalculator.domain.repository.CalculatorRepository
import io.lb.lbcalculator.util.extensions.invert
import io.lb.lbcalculator.util.extensions.isOperation
import io.lb.lbcalculator.util.extensions.toFormattedDouble
import io.lb.lbcalculator.util.extensions.toFormattedString

class CalculatorRepositoryImpl : CalculatorRepository {
    override fun concatNumber(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData {
        val isComma = button == CalculatorButton.COMMA
        val isEqualsLatter = data.lastOperation == CalculatorButton.EQUALS
        var typedNumber = data.typedNumber

        if (isComma && isEqualsLatter)
            typedNumber = "0"
        else if (isComma && button.text in data.typedNumber)
            return data.copy()
        else if (typedNumber == "NaN" || isEqualsLatter ||
            (!isComma && data.typedNumber == CalculatorButton.ZERO.text)
        ) typedNumber = ""

        return data.copy(
            typedNumber = "${typedNumber}${button.text}",
            lastOperation = if (isEqualsLatter)
                null
            else data.lastOperation
        )
    }

    override fun calculate(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData {
        val typedNumber = data.typedNumber.toFormattedDouble()
        val previousResult = data.previousResult
        val lastOperation = data.lastOperation

        if (button == CalculatorButton.EQUALS) {
            lastOperation?.let {
                val result = resultAccordingToOperation(it, typedNumber, previousResult)
                var lastEqualsTypedNumber = 0.0
                var lastEqualsOperation: CalculatorButton? = null

                if (lastOperation != CalculatorButton.EQUALS) {
                    lastEqualsTypedNumber = typedNumber
                    lastEqualsOperation = lastOperation
                }

                data.lastEqualsOperation?.let { operation ->
                    return data.copy(
                        typedNumber = resultAccordingToOperation(
                            operation,
                            data.lastEqualsTypedNumber,
                            result
                        ).toFormattedString(),
                        previousResult = 0.0,
                        lastOperation = lastOperation,
                    )
                }

                return data.copy(
                    typedNumber = result.toFormattedString(),
                    previousResult = 0.0,
                    lastOperation = button,
                    lastEqualsTypedNumber = lastEqualsTypedNumber,
                    lastEqualsOperation = lastEqualsOperation
                )
            }
        } else if (button.isOperation()) {
            return data.lastOperation?.takeIf {
                data.previousResult != 0.0
            }?.let {
                val result = resultAccordingToOperation(
                    lastOperation!!,
                    typedNumber,
                    previousResult
                )

                data.copy(
                    typedNumber = CalculatorButton.ZERO.text,
                    previousResult = result.takeIf {
                        it != 0.0 && !it.isNaN()
                    } ?: previousResult,
                    lastOperation = button,
                    lastEqualsTypedNumber = 0.0,
                    lastEqualsOperation = null
                )
            } ?: data.copy(
                typedNumber = CalculatorButton.ZERO.text,
                previousResult = typedNumber,
                lastOperation = button,
                lastEqualsTypedNumber = 0.0,
                lastEqualsOperation = null
            )
        }

        return data
    }

    override fun percentage(data: CalculatorData): CalculatorData {
        val typedNumber = data.typedNumber.toFormattedDouble()
        val previousResult = data.previousResult

        return data.lastOperation?.takeIf {
            it != CalculatorButton.EQUALS
        }?.let {
            val result = previousResult * typedNumber / 100

            calculate(
                data.copy(
                    typedNumber = result.toFormattedString()
                ),
                CalculatorButton.EQUALS
            )
        } ?: data.copy(
            typedNumber = (typedNumber / 100).toFormattedString()
        )
    }

    private fun resultAccordingToOperation(
        operation: CalculatorButton,
        typedNumber: Double,
        previousResult: Double,
    ) = when (operation) {
        CalculatorButton.PLUS -> previousResult + typedNumber
        CalculatorButton.MINUS -> previousResult - typedNumber
        CalculatorButton.MULTIPLY -> previousResult * typedNumber
        CalculatorButton.DIVISION ->
            if (typedNumber != 0.0)
                previousResult / typedNumber
            else Double.NaN

        else -> typedNumber
    }

    override fun invert(data: CalculatorData): CalculatorData {
        val invertedNumber = data.typedNumber
            .toFormattedDouble()
            .invert()

        return data.copy(
            typedNumber = invertedNumber.toFormattedString()
        )
    }

    override fun clear() = CalculatorData()
}
