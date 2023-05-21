package io.lb.lbcalculator.util.extensions

fun Double.toFormattedString() =
    if (this % 1.0 == 0.0) {
        toString().substringBefore(".")
    } else {
        toString().replace(".", ",")
    }

fun Double.invert() =
    if (this != 0.0) this * -1
    else this
