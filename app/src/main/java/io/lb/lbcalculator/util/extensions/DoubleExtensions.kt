package io.lb.lbcalculator.util.extensions

import java.text.DecimalFormat

fun Double.toFormattedString(): String {
    val decimalFormat = DecimalFormat("###0.${"#".repeat(20)}")
    return decimalFormat.format(this).replace(".", ",")
}

fun Double.invert() =
    if (this != 0.0) this * -1
    else this
