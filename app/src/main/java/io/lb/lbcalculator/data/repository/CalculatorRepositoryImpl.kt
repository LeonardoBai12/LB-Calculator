package io.lb.lbcalculator.data.repository

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.model.CalculatorData
import io.lb.lbcalculator.domain.repository.CalculatorRepository

class CalculatorRepositoryImpl : CalculatorRepository {
    override fun concatNumber(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData {
        return data.copy(
            typedNumber = "${data.typedNumber}${button.text}"
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
        return data
    }

    override fun reset() = CalculatorData()
}
