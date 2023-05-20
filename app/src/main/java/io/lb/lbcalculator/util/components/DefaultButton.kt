package io.lb.lbcalculator.util.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lb.lbcalculator.util.enums.ButtonType
import io.lb.lbcalculator.util.enums.CalculatorButton

@Composable
fun DefaultButton(
    calculatorButton: CalculatorButton,
    operation: MutableState<String>,
) {
    Button(
        modifier = Modifier
            .padding(3.dp)
            .height(82.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = when (calculatorButton.buttonType) {
                ButtonType.NUMBER -> MaterialTheme.colorScheme.primary
                ButtonType.CONVERSION -> MaterialTheme.colorScheme.secondary
                else -> MaterialTheme.colorScheme.tertiary
            },
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = {
            when (calculatorButton.buttonType) {
                ButtonType.NUMBER -> operation.value += calculatorButton.text
                ButtonType.OPERATION -> {

                }
                ButtonType.CONVERSION -> operation.value = "0"
            }
        }
    ) {
        Text(
            text = calculatorButton.text,
            fontSize = 24.sp,
        )
    }
}