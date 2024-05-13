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

        int maxAvalableDistance = endurance / energy;
        System.out.println(String.format("%s Максимальная доступная дистанция: %d км.", name, maxAvalableDistance ));
        if (maxAvalableDistance == distance || maxAvalableDistance > distance) {
            time = ((float) distance / speed);
            endurance -= (energy * distance);
        } else {
            time = ((float) maxAvalableDistance / speed);
            System.out.println(String.format("%s На дистанцию %d км ушло: %.2f ч.", name, maxAvalableDistance, time));
            endurance -= (energy * maxAvalableDistance);
            System.out.println(name + message);
            return -1;
        }

        return time;
    }

}
