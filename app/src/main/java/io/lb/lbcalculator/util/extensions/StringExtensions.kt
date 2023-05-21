package io.lb.lbcalculator.util.extensions

fun String.toFormattedDouble() = replace(",", ".").toDoubleOrNull() ?: 0.0
