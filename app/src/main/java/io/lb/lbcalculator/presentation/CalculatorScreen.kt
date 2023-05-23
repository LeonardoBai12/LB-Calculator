package io.lb.lbcalculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import io.lb.lbcalculator.util.components.AutoSizeText
import io.lb.lbcalculator.domain.model.CalculatorButton
import io.lb.lbcalculator.util.components.CalculatorDefaultButton
import io.lb.lbcalculator.util.components.ClearButton
import io.lb.lbcalculator.util.extensions.emptyIfEquals
import io.lb.lbcalculator.util.extensions.emptyIfZero

@ExperimentalMaterial3Api
@Composable
fun CategoryScreen(viewModel: CalculatorViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val isCalculating = remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 12.dp),
                text = with(state.data) {
                    "${previousResult.emptyIfZero()} ${lastOperation.emptyIfEquals()}"
                },
                fontSize = 32.sp,
                textAlign = TextAlign.End
            )

            Box(
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth()
                    .padding(bottom = 2.dp)
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.BottomEnd,
            ) {
                AutoSizeText(
                    text = state.data.typedNumber,
                    textStyle = TextStyle(fontSize = 72.sp),
                )
            }

            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                val buttons = CalculatorButton.values()

                items(buttons.copyOfRange(0, 16)) {
                    if (it == CalculatorButton.AC) {
                        ClearButton(isCalculating = isCalculating.value) {
                            isCalculating.value = false
                            viewModel.doCalculatorAction(button = it)
                        }
                    } else {
                        CalculatorDefaultButton(button = it) {
                            isCalculating.value = true
                            viewModel.doCalculatorAction(button = it)
                        }
                    }
                }

                item(span = { GridItemSpan(2) }) {
                    val it = buttons[16]

                    CalculatorDefaultButton(button = it) {
                        isCalculating.value = true
                        viewModel.doCalculatorAction(button = it)
                    }
                }

                items(buttons.copyOfRange(17, 19)) {
                    CalculatorDefaultButton(button = it) {
                        isCalculating.value = true
                        viewModel.doCalculatorAction(button = it)
                    }
                }
            }
        }
    }
}
