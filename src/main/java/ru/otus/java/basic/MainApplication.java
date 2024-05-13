package ru.otus.java.basic;

import ru.otus.java.basic.homework.hw5.animals.*;

public class MainApplication {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Cat("Барсик", 5, 25),
                new Dog("Полкан", 10, 44),
                new Horse("Игогошечка", 15, 148),
                new Horse("Стрела", 15, 3)
        };

        for (int i = 0; i < animals.length; i++) {
            var animal = animals[i];
            System.out.println(animal.info());

            var runTime = animal.run(3);
            if (runTime > -1f) {
                System.out.println(String.format("%s бежал: %.2f ч.", animal.getName(), runTime));
            } else {
                System.out.println(String.format("%s недобежал", animal.getName()));
            }
            if (animal instanceof WaterfowlAnimal waterfowlAnimal) {
                var swimTime = waterfowlAnimal.swim(30);
                if (swimTime > -1f) {
                    System.out.println(String.format("%s плыл: %.2f ч.", animal.getName(), swimTime));
                } else {
                    System.out.println(String.format("%s недоплыл", animal.getName()));
                }
            }
            System.out.println(animal.info());
        }

    }
}
