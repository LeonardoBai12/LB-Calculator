package io.lb.lbcalculator.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.lb.lbcalculator.domain.model.ButtonType
import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.domain.use_cases.CalculatorUseCases
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val useCases: CalculatorUseCases
) : ViewModel() {
    private val _state = mutableStateOf(CalculatorState())
    val state: State<CalculatorState> = _state

    fun doCalculatorAction(button: CalculatorButton) {
        val data = state.value.data

        _state.value = when (button.buttonType) {
            ButtonType.NUMBER -> {
                state.value.copy(
                    data = useCases.numberUseCase(data, button)
                )
            }
            ButtonType.OPERATION -> {
                state.value.copy(
                    data = useCases.operationUseCase(data, button)
                )
            }
            ButtonType.CONVERSION -> {
                state.value.copy(
                    data = useCases.conversionUseCase(data, button)
                )
            }
        }
    }
}
