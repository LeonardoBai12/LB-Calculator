package io.lb.lbcalculator.data.repository

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.repository.CalculatorRepository

class CalculatorRepositoryImpl : CalculatorRepository {
    override fun concatNumber(
        typedNumber: String,
        button: CalculatorButton
    ) = "$typedNumber${button.text}"

    override fun calculate(typedNumber: String, button: CalculatorButton): String {
        return "Not yet implemented"
    }

    override fun percentage(typedNumber: String): String {
        return "Not yet implemented"
    }

    override fun invert(typedNumber: String): String {
        return "Not yet implemented"
    }

    override fun reset() = CalculatorButton.ZERO.text
}
