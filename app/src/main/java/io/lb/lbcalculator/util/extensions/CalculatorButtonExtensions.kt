package io.lb.lbcalculator.util.extensions

import io.lb.lbcalculator.domain.model.CalculatorButton

fun CalculatorButton?.emptyIfEquals() =
    takeIf { this != CalculatorButton.EQUALS }?.text ?: ""

fun CalculatorButton.isOperation() =
    this == CalculatorButton.PLUS ||
        this == CalculatorButton.MINUS ||
        this == CalculatorButton.MULTIPLY ||
        this == CalculatorButton.DIVISION
