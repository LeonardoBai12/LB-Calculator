package io.lb.lbcalculator.presentation

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.model.CalculatorData

data class CalculatorState(
    val data: CalculatorData = CalculatorData()
)
