package ru.otus.java.basic.homework.hw6.animals;

import ru.otus.java.basic.homework.hw6.bowls.Bowl;

public class Cat {

    private String name;
    private int appetite;

    public void gotHungry() {
        this.bellyful = false;
    }

    private boolean bellyful;

    public String getName() {
        return name;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eatFromBowl(Bowl bowl) {
        if (bellyful) {
            System.out.println(name + " кушать не хочет.");
            return false;
        }
        bellyful = bowl.getFood(appetite);
        return bellyful;
    }
}
