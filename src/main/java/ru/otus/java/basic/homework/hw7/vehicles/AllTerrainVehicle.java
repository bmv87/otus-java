package ru.otus.java.basic.homework.hw7.vehicles;

import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

import java.util.Map;

public class AllTerrainVehicle extends MotorVehicle {

    public AllTerrainVehicle(int energyVolume, int consumption) {
        super(MotorVehicleEnum.ALL_TERRAIN_VEHICLE, energyVolume, consumption);
        this.availableTerrainTypes.putAll(Map.ofEntries(
                Map.entry(TerrainTypeEnum.DENSE_FOREST, true),
                Map.entry(TerrainTypeEnum.PLAIN, true),
                Map.entry(TerrainTypeEnum.SWAMP, true)
        ));
    }
}
