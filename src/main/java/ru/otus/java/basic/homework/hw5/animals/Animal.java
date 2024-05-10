package ru.otus.java.basic.homework.hw5.animals;

public abstract class Animal {

    String name;
    int speed;
    int endurance;
    int energyForRunning;

    public Animal(String name, int speed, int endurance) {
        this.name = name;
        this.speed = speed;
        this.endurance = endurance;
        this.energyForRunning = 1;
    }


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getEnergyForRunning() {
        return energyForRunning;
    }


    public float run(int distance) {
        return move(distance, energyForRunning, " устал. Прилег отдохнуть.");
    }


    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Имя: %s", name));
        sb.append(System.lineSeparator());
        sb.append(String.format("Скорость движения: %d км/ч", speed));
        sb.append(System.lineSeparator());
        sb.append(String.format("Выносливость: %d единиц", endurance));
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    float move(int distance, int energy, String message) {

        if (energy == 0) {
            System.out.println(name + " Такого не умеет.");
            return -1;
        }
        float time = 0;

        for (int i = 1; i <= distance; i++) {
            if (endurance < energy) {
                System.out.println(name + message);
                return -1;
            }
            time += (speed / distance);
            endurance -= energy;
        }
        return time;
    }

}
