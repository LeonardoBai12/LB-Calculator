package io.lb.lbcalculator.util.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

private const val MAX_DIGITS = 7

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
                if (text.length <= MAX_DIGITS)
                    value = originalStyle

                if (!it.didOverflowWidth)
                    return@Text

                val scaleFactor = it.size.width / it.multiParagraph.width

                value = value.copy(
                    fontSize = value.copy().fontSize * scaleFactor
                )
            }
        }
    )
}
