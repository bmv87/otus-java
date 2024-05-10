package ru.otus.java.basic.homework.hw5.animals;

public class WaterfowlAnimal extends Animal {
    int energyForSwimming;

    public WaterfowlAnimal(String name, int speed, int endurance, int energyForSwimming) {
        super(name, speed, endurance);
        this.energyForSwimming = energyForSwimming;
    }

    public int getEnergyForSwimming() {
        return energyForSwimming;
    }

    public float swim(int distance) {
        return move(distance, energyForSwimming, " устал. Плыть больше не может.");
    }
}
