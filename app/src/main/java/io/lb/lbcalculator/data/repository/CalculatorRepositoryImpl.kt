package io.lb.lbcalculator.data.repository

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.model.CalculatorData
import io.lb.lbcalculator.domain.repository.CalculatorRepository
import io.lb.lbcalculator.util.extensions.invert
import io.lb.lbcalculator.util.extensions.toFormattedDouble
import io.lb.lbcalculator.util.extensions.toFormattedString

class CalculatorRepositoryImpl : CalculatorRepository {
    override fun concatNumber(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData {
        val isComma = button == CalculatorButton.COMMA
        var typedNumber = data.typedNumber

        if (isComma && button.text in data.typedNumber)
            return data.copy()
        else if (!isComma && data.typedNumber == CalculatorButton.ZERO.text)
            typedNumber = ""

        return data.copy(
            typedNumber = "${typedNumber}${button.text}"
        )
    }

    override fun calculate(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData {
        return data
    }

    override fun percentage(data: CalculatorData): CalculatorData {
        return data
    }

    override fun invert(data: CalculatorData): CalculatorData {
        val invertedNumber = data.typedNumber
            .toFormattedDouble()
            .invert()

        return data.copy(
            typedNumber = invertedNumber.toFormattedString()
        )
    }

    override fun reset() = CalculatorData()
}
