package io.lb.lbcalculator.util.extensions

import io.lb.lbcalculator.domain.model.CalculatorButton

fun CalculatorButton?.emptyIfEquals() =
    takeIf { this != CalculatorButton.EQUALS }?.text ?: ""