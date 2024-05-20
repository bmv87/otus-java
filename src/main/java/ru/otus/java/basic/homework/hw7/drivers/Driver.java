package ru.otus.java.basic.homework.hw7.drivers;

import ru.otus.java.basic.homework.hw7.Drivable;
import ru.otus.java.basic.homework.hw7.Energy;
import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;

public class Driver implements Energy {
    private final String name;
    private Drivable currentTransport;
    private int energyVolume;
    private final int consumption;

    public Driver(String name, int energyVolume, int consumption) {
        this.name = name;
        this.energyVolume = energyVolume;
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    private void consumeEnergy(int distance) {
        var energyConsumption = distance * consumption;
        energyVolume -= energyConsumption;
        System.out.printf("%s: потратил %d ед. энергии. \n", name, distance);
    }

    @Override
    public boolean isEnoughEnergy(int distance) {
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

    public boolean takeVehicle(Drivable vehicle) {
        if (vehicle == null) {
            return false;
        }
        if (vehicle instanceof Energy vEnergy) {
            if (vEnergy.isEnoughEnergy(1)) {
                currentTransport = vehicle;
                return true;
            }
            return false;
        }
        if (isEnoughEnergy(1)) {
            currentTransport = vehicle;
            return true;
        }
        return false;
    }

    public boolean drive(int distance, TerrainTypeEnum terrainType) {
        if (currentTransport == null) {
            System.out.println("Транспорт не выбран!");
            return false;
        }

        if (distance <= 0) {
            System.out.println("Неверно указана дистанция!");
            return false;
        }
        if (!currentTransport.isAvailableTerrain(terrainType)) {
            return false;
        }
        if (currentTransport instanceof Energy) {
            return currentTransport.move(distance, terrainType);
        }

        if (isEnoughEnergy(distance)) {
            if (currentTransport.move(distance, terrainType)) {
                consumeEnergy(distance);
                return true;
            }
        }
        System.out.printf("%s не осилит управление этим транспортом!\n", name);
        return false;
    }

    public boolean leaveVehicle() {
        if (currentTransport == null) {
            System.out.println("Водитель не может встать. Транспорт не выбран!");
            return false;
        }
        currentTransport = null;
        return true;
    }
}
