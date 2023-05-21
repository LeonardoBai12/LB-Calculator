package io.lb.lbcalculator.domain.use_cases

data class CalculatorUseCases(
    val conversionUseCase: ConversionUseCase,
    val numberUseCase: NumberUseCase,
    val operationUseCase: OperationUseCase,
)
