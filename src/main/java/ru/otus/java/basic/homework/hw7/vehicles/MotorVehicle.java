package ru.otus.java.basic.homework.hw7.vehicles;

import ru.otus.java.basic.homework.hw7.Drivable;
import ru.otus.java.basic.homework.hw7.Energy;
import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

import java.util.EnumMap;

public abstract class MotorVehicle implements Energy, Drivable {

    protected int energyVolume;
    protected final MotorVehicleEnum vehicleType;
    protected final int consumption;
    protected final EnumMap<TerrainTypeEnum, Boolean> availableTerrainTypes = new EnumMap(TerrainTypeEnum.class);

    public MotorVehicle(MotorVehicleEnum vehicleType, int energyVolume, int consumption) {
        if (vehicleType == null) {
            throw new IllegalArgumentException("Тип транспорта не задан!");
        }
        if (energyVolume < 0) {
            throw new IllegalArgumentException("Запас энергии не задан!");
        }
        if (consumption < 0) {
            throw new IllegalArgumentException("Расход энергии не задан!");
        }
        this.vehicleType = vehicleType;
        this.energyVolume = energyVolume;
        this.consumption = consumption;
    }

    private void consumeEnergy(int distance) {
        var energyConsumption = distance * consumption;
        energyVolume -= energyConsumption;
        System.out.printf("%s: проехал %d км. %n", vehicleType.getDescription(), distance);
    }

    @Override
    public String getTypeName() {
        return vehicleType.getDescription();
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
        if (distance <= 0) {
            System.out.println("Неверно указана дистанция!");
            return false;
        }
        if (!isAvailableTerrain(terrainType)) {
            return false;
        }
        if (isEnoughEnergy(distance)) {
            consumeEnergy(distance);
            return true;
        }
        System.out.printf("%s: недостаточно энергии для продвижения на указанную дистанцию!%n", vehicleType.getDescription());
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
            System.out.printf("%s: местность '%s' недоступна.%n", vehicleType.getDescription(), terrainType.getDescription());
        return isAvailable != null && isAvailable;
    }
}