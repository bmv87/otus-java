package ru.otus.java.basic.homework.hw13;

public enum OperationsEnum {
    PLUS('+'),
    MINUS('-'),
    MULTIPLICATION('*');

    private final char symbol;


    OperationsEnum(char symbol) {
        this.symbol = symbol;
    }


    public static OperationsEnum tryParse(char symbol) {
        return switch (symbol) {
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> MULTIPLICATION;
            default -> null;
        };
    }

    public char getSymbol() {
        return symbol;
    }
}
