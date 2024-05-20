package ru.otus.java.basic.homework.hw7.terrain;

public enum TerrainTypeEnum {

    DENSE_FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    TerrainTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private final String description;
}
