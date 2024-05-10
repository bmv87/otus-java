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

    public void setEnergyForSwimming(int energyForSwimming) {
        this.energyForSwimming = energyForSwimming;
        System.out.println(name + " отдохнул и может поплавать.");

    }

    public float swim(int distance) {
        return move(distance, energyForSwimming, " устал. Плыть больше не может.");
    }
}
