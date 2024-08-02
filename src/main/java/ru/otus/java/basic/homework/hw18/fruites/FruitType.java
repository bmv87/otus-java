package ru.otus.java.basic.homework.hw18.fruites;

public enum FruitType {
    APPLE("Яблоко"),
    ORANGE("Апельсин");

    private final String description;

    FruitType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
