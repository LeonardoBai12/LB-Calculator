package io.lb.lbcalculator.domain.use_cases

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.model.CalculatorData
import io.lb.lbcalculator.domain.repository.CalculatorRepository

class NumberUseCase(
    private val repository: CalculatorRepository,
) {
    operator fun invoke(
        data: CalculatorData,
        button: CalculatorButton
    ) = repository.concatNumber(data, button)
}
