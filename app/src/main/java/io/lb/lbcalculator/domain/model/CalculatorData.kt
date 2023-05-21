package io.lb.lbcalculator.domain.model

data class CalculatorData(
    var typedNumber: String = CalculatorButton.ZERO.text,
    var previousNumber: String = CalculatorButton.ZERO.text,
    var lastOperation: CalculatorButton? = null
)
