package ru.otus.java.basic.homework.hw7.vehicles;

import ru.otus.java.basic.homework.hw7.Drivable;
import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

import java.util.EnumMap;
import java.util.Map;

public class Bike implements Drivable {

    private static final String TYPE_NAME = "Велосипед";

    private final EnumMap<TerrainTypeEnum, Boolean> availableTerrainTypes;

    public Bike() {
        this.availableTerrainTypes = new EnumMap<>(Map.ofEntries(
                Map.entry(TerrainTypeEnum.DENSE_FOREST, true),
                Map.entry(TerrainTypeEnum.PLAIN, true),
                Map.entry(TerrainTypeEnum.SWAMP, false)
        ));
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public boolean move(int distance, TerrainTypeEnum terrainType) {
        if (!isAvailableTerrain(terrainType)) {
            return false;
        }
        System.out.printf("%s: проехал %d км. %n", TYPE_NAME, distance);
        return true;
    }

    @Override
    public boolean isAvailableTerrain(TerrainTypeEnum terrainType) {
        if (terrainType == null) {
            System.out.println("Тип местности не задан!");
            return false;
        }
        var isAvailable = availableTerrainTypes.get(terrainType);
        if (isAvailable == null || !isAvailable)
            System.out.printf("%s: местность '%s' недоступна. %n", TYPE_NAME, terrainType.getDescription());
        return isAvailable != null && isAvailable;
    }
}
