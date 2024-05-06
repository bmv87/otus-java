package ru.otus.java.basic.homework.hw4;

public enum ColorsEnum {
    BLACK("Черный"),
    WITE("Белый"),
    RED("Красный"),
    GREEN("Зеленый");

    private final String name;

    private ColorsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
