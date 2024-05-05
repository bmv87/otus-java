package ru.otus.java.basic.homework.hw4;

public enum ColorsEnum {
    black("Черный"),
    wite("Белый"),
    red("Красный"),
    green("Зеленый");

    private final String name;

    private ColorsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
