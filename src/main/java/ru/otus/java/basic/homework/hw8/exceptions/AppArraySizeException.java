package ru.otus.java.basic.homework.hw8.exceptions;

public class AppArraySizeException extends Exception {
    public AppArraySizeException(int fixLength) {
        super(String.format("Недопустимый размер массива. Должен быть %dx%d.", fixLength, fixLength));
    }
}
