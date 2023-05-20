package io.lb.lbcalculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lb.lbcalculator.util.components.DefaultButton
import io.lb.lbcalculator.util.enums.AutoSizeText
import io.lb.lbcalculator.util.enums.CalculatorButton

@ExperimentalMaterial3Api
@Composable
fun CategoryScreen() {
    val operation = remember {
        mutableStateOf("0")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            AutoSizeText(
                modifier = Modifier.padding(
                    vertical = 8.dp,
                    horizontal = 16.dp
                ),
                text = operation.value,
                textStyle = TextStyle(fontSize = 72.sp)
            )
            
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                val buttons = CalculatorButton.values()

                items(buttons.copyOfRange(0, 16)) {
                    DefaultButton(
                        calculatorButton = it,
                        operation = operation
                    )
                }

                item(span = { GridItemSpan(2) }) {
                    DefaultButton(
                        calculatorButton = buttons[16],
                        operation = operation
                    )
                }

                items(buttons.copyOfRange(17, 19)) {
                    DefaultButton(
                        calculatorButton = it,
                        operation = operation
                    )
                }
            }
        }
    }
}