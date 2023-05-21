package io.lb.lbcalculator.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.use_cases.CalculatorUseCases
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val useCases: CalculatorUseCases
) : ViewModel() {
    fun onClickNumberButton(
        typedString: String,
        button: CalculatorButton
    ) = useCases.numberUseCase(typedString, button)

    fun onClickOperationButton(
        typedString: String,
        button: CalculatorButton
    ) = useCases.operationUseCase(typedString, button)

    fun onClickConversionButton(
        typedString: String,
        button: CalculatorButton
    ) = useCases.conversionUseCase(typedString, button)
}
