package io.lb.lbcalculator.domain.use_cases

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.repository.CalculatorRepository

class ConversionUseCase(
    private val repository: CalculatorRepository,
) {
    operator fun invoke(
        typedNumber: String,
        button: CalculatorButton
    ) = when(button) {
        CalculatorButton.AC -> repository.reset()
        CalculatorButton.PLUS_MINUS -> repository.invert(typedNumber)
        else -> repository.percentage(typedNumber)
    }
}
