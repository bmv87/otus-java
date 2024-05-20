package ru.otus.java.basic.homework.hw7;

import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

public interface Drivable {
    String getTypeName();
    boolean move(int distance, TerrainTypeEnum terrainType);
    boolean isAvailableTerrain(TerrainTypeEnum terrainType);
}
