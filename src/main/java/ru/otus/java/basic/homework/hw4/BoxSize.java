package ru.otus.java.basic.homework.hw4;

import java.util.regex.Matcher;

import static java.util.Optional.ofNullable;

public class BoxSize {
    private final int width;
    private final int height;
    private final int depth;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public BoxSize(int width, int height, int depth) {
        isValidSizeParams(width, height, depth).throwIfNotValid();

        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Размер:");
        sb.append(System.lineSeparator());
        sb.append(String.format("Ширина: %d", width));
        sb.append(System.lineSeparator());
        sb.append(String.format("Высота: %s", height));
        sb.append(System.lineSeparator());
        sb.append(String.format("Глубина: %s", depth));
        sb.append(System.lineSeparator());

        return sb.toString();
    }


    private ValidationResult isValidSizeParams(int width, int height, int depth) {
        var result = new ValidationResult(true);
        if (width <= 0 || height <= 0 || depth <= 0) {
            result.setValid(false);
            result.setMessage(String.format("Размеры коробки заданы некорректно. Ширина: %s, Высота: %s, Глубина: %s", width, height, depth));
        }
        return result;
    }
}
