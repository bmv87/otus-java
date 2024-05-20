package ru.otus.java.basic.homework.hw7.vehicles;

public enum MotorVehicleEnum {
    ALL_TERRAIN_VEHICLE("Вездеход"),
    CAR("Автомобиль");

    private final String description;
    MotorVehicleEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
