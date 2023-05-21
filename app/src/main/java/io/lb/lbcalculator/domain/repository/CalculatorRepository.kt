package io.lb.lbcalculator.domain.repository

import io.lb.lbcalculator.domain.model.CalculatorButton

interface CalculatorRepository {
    fun concatNumber(typedNumber: String, button: CalculatorButton): String
    fun calculate(typedNumber: String, button: CalculatorButton): String
    fun percentage(typedNumber: String):String
    fun invert(typedNumber: String): String
    fun reset(): String
}
