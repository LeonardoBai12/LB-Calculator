package io.lb.lbcalculator.domain.model

data class CalculatorData(
    var typedNumber: String = CalculatorButton.ZERO.text,
    var previousResult: Double = 0.0,
    var lastOperation: CalculatorButton? = null,
    var lastEqualsTypedNumber: Double = 0.0,
    var lastEqualsOperation: CalculatorButton? = null,
)
