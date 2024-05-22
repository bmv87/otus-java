package ru.otus.java.basic.homework.hw7.vehicles;

import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

import java.util.Map;

public class Car extends MotorVehicle {

    public Car(int energyVolume, int consumption) {
        super(MotorVehicleEnum.CAR, energyVolume, consumption);
        this.availableTerrainTypes.putAll(Map.ofEntries(
                Map.entry(TerrainTypeEnum.DENSE_FOREST, false),
                Map.entry(TerrainTypeEnum.PLAIN, true),
                Map.entry(TerrainTypeEnum.SWAMP, false)
        ));
    }
}
