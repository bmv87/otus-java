package ru.otus.java.basic.homework.hw6.animals;

import ru.otus.java.basic.homework.hw6.bowls.Bowl;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean bellyful;

    public void gotHungry() {
        this.bellyful = false;
    }

    public String getName() {
        return name;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Bowl bowl) {
        if (bellyful) {
            System.out.println(name + " кушать не хочет.");
            return false;
        }
        bellyful = bowl.reduceFood(appetite);
        return bellyful;
    }
}
