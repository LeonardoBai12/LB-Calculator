package io.lb.lbcalculator.util.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import io.lb.lbcalculator.domain.model.CalculatorButton

@Composable
fun AutoSizeText(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    val scaledTextStyle = remember {
        mutableStateOf(textStyle)
    }
    val originalStyle = textStyle.copy()

    Text(
        text = text,
        modifier = modifier,
        style = scaledTextStyle.value,
        softWrap = false,
        onTextLayout = {
            scaledTextStyle.apply {
                if (text == CalculatorButton.ZERO.text)
                    value = originalStyle

                value = value.copy(
                    fontSize = value.copy().fontSize *
                            it.size.width / it.multiParagraph.width
                )
            }
        }
    )
}