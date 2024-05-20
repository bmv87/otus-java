package ru.otus.java.basic.homework.hw7;

import ru.otus.java.basic.homework.hw7.drivers.Driver;
import ru.otus.java.basic.homework.hw7.terrain.TerrainTypeEnum;
import ru.otus.java.basic.homework.hw7.vehicles.AllTerrainVehicle;
import ru.otus.java.basic.homework.hw7.vehicles.Bike;
import ru.otus.java.basic.homework.hw7.vehicles.Car;
import ru.otus.java.basic.homework.hw7.vehicles.Horse;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver("Вася", 20, 2);

        Drivable[] vehicles = new Drivable[]{
                new AllTerrainVehicle(100, 4),
                new Car(80, 3),
                new Horse(40, 4),
                new Bike()
        };

        for (Drivable vehicle : vehicles) {
            System.out.println();
            System.out.printf("============== %s =============== \n", vehicle.getClass().getSimpleName());
            driver.leaveVehicle();
            if (!driver.drive(20, TerrainTypeEnum.DENSE_FOREST)) {
                System.out.println("Не удалось прокатиться");
            }
            if (driver.takeVehicle(vehicle)) {
                System.out.println(driver.getName() + " выбрал транспорт: " + vehicle.getTypeName());
            } else {
                System.out.println("Не удалось взять транспорт: " + vehicle.getTypeName());
            }
            if (!driver.drive(20, TerrainTypeEnum.DENSE_FOREST)) {
                System.out.println("Не удалось прокатиться по местности: " + TerrainTypeEnum.DENSE_FOREST.getDescription());
            }
            if (!driver.drive(5, TerrainTypeEnum.PLAIN)) {
                System.out.println("Не удалось прокатиться по местности: " + TerrainTypeEnum.PLAIN.getDescription());
            }
            if (!driver.drive(20, TerrainTypeEnum.SWAMP)) {
                System.out.println("Не удалось прокатиться по местности: " + TerrainTypeEnum.SWAMP.getDescription());
            }
            driver.leaveVehicle();
        }
    }
}
