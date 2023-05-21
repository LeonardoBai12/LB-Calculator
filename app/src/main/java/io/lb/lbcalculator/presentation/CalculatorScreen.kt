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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import io.lb.lbcalculator.domain.model.ButtonType
import io.lb.lbcalculator.util.components.DefaultButton
import io.lb.lbcalculator.util.enums.AutoSizeText
import io.lb.lbcalculator.domain.model.CalculatorButton

@ExperimentalMaterial3Api
@Composable
fun CategoryScreen(viewModel: CalculatorViewModel = hiltViewModel()) {
    val state = viewModel.state.value

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
            Box(
                modifier = Modifier
                    .height(100.dp)
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
                    DefaultButton(button = it) {
                        viewModel.doCalculatorAction(button = it)
                    }
                }

                item(span = { GridItemSpan(2) }) {
                    val it = buttons[16]

                    DefaultButton(button = it) {
                        viewModel.doCalculatorAction(button = it)
                    }
                }

                items(buttons.copyOfRange(17, 19)) {
                    DefaultButton(button = it) {
                        viewModel.doCalculatorAction(button = it)
                    }
                }
            }
        }
    }
}
