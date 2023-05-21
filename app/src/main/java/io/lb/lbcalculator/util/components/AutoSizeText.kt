package io.lb.lbcalculator.util.enums

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
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
    val readyToDraw = remember {
        mutableStateOf(false)
    }
    val originalStyle = textStyle.copy()

    Text(
        text = text,
        modifier = modifier.drawWithContent {
            if (readyToDraw.value) {
                drawContent()
            }
        },
        style = scaledTextStyle.value,
        softWrap = false,
        onTextLayout = {
            scaledTextStyle.apply {
                if (text == CalculatorButton.ZERO.text)
                    value = originalStyle

                if (it.didOverflowWidth) {
                    value = value.copy(
                        fontSize = value.fontSize *
                                it.size.width / it.multiParagraph.width
                    )
                } else {
                    readyToDraw.value = true
                }
            }
        }
    )
}