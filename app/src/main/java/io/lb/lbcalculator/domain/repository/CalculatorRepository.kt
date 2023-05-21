package io.lb.lbcalculator.domain.repository

import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.model.CalculatorData

interface CalculatorRepository {
    fun concatNumber(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData
    fun calculate(
        data: CalculatorData,
        button: CalculatorButton
    ): CalculatorData
    fun percentage(data: CalculatorData): CalculatorData
    fun invert(
        data: CalculatorData,
    ): CalculatorData
    fun clear(): CalculatorData
}
