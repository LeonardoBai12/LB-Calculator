package io.lb.lbcalculator.domain.model

enum class CalculatorButton(
    val text :String,
    val buttonType: ButtonType
) {
    AC("AC", ButtonType.CONVERSION),
    PLUS_MINUS("+/-", ButtonType.CONVERSION),
    PERCENT("%", ButtonType.CONVERSION),
    DIVISION("/", ButtonType.OPERATION),

    SEVEN("7", ButtonType.NUMBER),
    EIGHT("8", ButtonType.NUMBER),
    NINE("9", ButtonType.NUMBER),
    MULTIPLY("x", ButtonType.OPERATION),

    FOUR("4", ButtonType.NUMBER),
    FIVE("5", ButtonType.NUMBER),
    SIX("6", ButtonType.NUMBER),
    MINUS("-", ButtonType.OPERATION),

    ONE("1", ButtonType.NUMBER),
    TWO("2", ButtonType.NUMBER),
    THREE("3", ButtonType.NUMBER),
    PLUS("+", ButtonType.OPERATION),

    ZERO("0", ButtonType.NUMBER),
    COMMA(",", ButtonType.NUMBER),
    EQUALS("=", ButtonType.OPERATION),

    C("C", ButtonType.CONVERSION),
}
