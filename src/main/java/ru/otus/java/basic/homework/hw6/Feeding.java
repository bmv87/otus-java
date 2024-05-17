package ru.otus.java.basic.homework.hw6;

import ru.otus.java.basic.homework.hw6.animals.Cat;
import ru.otus.java.basic.homework.hw6.bowls.Bowl;

public class Feeding {
    public static void main(String[] args) {

        Cat[] cats = new Cat[]{
                new Cat("Barsik", 20),
                new Cat("Pushok", 25),
                new Cat("Rizhik", 15),
                new Cat("Vasik", 5),
        };

        Bowl bowl = new Bowl(50);

        for (Cat cat : cats) {
            if(cat.eatFromBowl(bowl)){
                System.out.println(cat.getName() + " поел.");
                continue;
            }
            System.out.println(cat.getName() + " не стал есть из этой миски.");
        }
        bowl.putFood(100);
        for (Cat cat : cats) {
            if(cat.eatFromBowl(bowl)){
                System.out.println(cat.getName() + " поел.");
                continue;
            }
            System.out.println(cat.getName() + " не стал есть из этой миски.");
        }
    }
}
