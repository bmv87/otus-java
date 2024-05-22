package ru.otus.java.basic.homework.hw7.vehicles;

import ru.otus.java.basic.homework.hw7.Drivable;
import ru.otus.java.basic.homework.hw7.Energy;
import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

import java.util.EnumMap;
import java.util.Map;

public class Horse implements Energy, Drivable {

    private static final String TYPE_NAME = "Лошадь";
    private int energyVolume;
    private final int consumption;
    private final EnumMap<TerrainTypeEnum, Boolean> availableTerrainTypes;

    public Horse(int energyVolume, int consumption) {
        if (energyVolume < 0) {
            throw new IllegalArgumentException("Запас энергии не задан!");
        }
        if (consumption < 0) {
            throw new IllegalArgumentException("Расход энергии не задан!");
        }
        this.energyVolume = energyVolume;
        this.consumption = consumption;
        this.availableTerrainTypes = new EnumMap<>(Map.ofEntries(
                Map.entry(TerrainTypeEnum.DENSE_FOREST, true),
                Map.entry(TerrainTypeEnum.PLAIN, true),
                Map.entry(TerrainTypeEnum.SWAMP, false)));
    }

    private void consumeEnergy(int distance) {
        var energyConsumption = distance * consumption;
        energyVolume -= energyConsumption;
        System.out.printf("%s: проехал %d км. %n", TYPE_NAME, distance);
    }


    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public boolean isEnoughEnergy(int distance) {
        if (distance <= 0) {
            System.out.println("Неверно указана дистанция!");
            return false;
        }
        var energyConsumption = distance * consumption;
        return energyVolume >= energyConsumption;
    }

    @Override
    public void setEnergyVolume(int energyVolume) {
        if (energyVolume <= 0) {
            System.out.println("Неправильно задано количество энергии.");
            return;
        }
        this.energyVolume = energyVolume;
    }

    @Override
    public boolean move(int distance, TerrainTypeEnum terrainType) {
        if (!isAvailableTerrain(terrainType)) {
            return false;
        }
        if (isEnoughEnergy(distance)) {
            consumeEnergy(distance);
            return true;
        }
        System.out.printf("%s: недостаточно энергии для продвижения на указанную дистанцию!%n", TYPE_NAME);
        return false;
    }

    @Override
    public boolean isAvailableTerrain(TerrainTypeEnum terrainType) {
        if (terrainType == null) {
            System.out.println("Тип местности не задан!");
            return false;
        }
        var isAvailable = availableTerrainTypes.get(terrainType);
        if (isAvailable == null || !isAvailable)
            System.out.printf("%s: местность '%s' недоступна.%n", TYPE_NAME, terrainType.getDescription());
        return isAvailable != null && isAvailable;
    }
}
