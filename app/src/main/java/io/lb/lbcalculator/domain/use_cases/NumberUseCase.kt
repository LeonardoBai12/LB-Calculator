package io.lb.lbcalculator.domain.use_cases

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.repository.CalculatorRepository

class NumberUseCase(
    private val repository: CalculatorRepository,
) {
    operator fun invoke(
        typedNumber: String,
        button: CalculatorButton
    ) = repository.concatNumber(typedNumber, button)
}
