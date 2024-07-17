package ru.otus.java.basic.homework.hw18;

import ru.otus.java.basic.homework.hw18.fruites.Apple;
import ru.otus.java.basic.homework.hw18.fruites.Fruit;
import ru.otus.java.basic.homework.hw18.fruites.Orange;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
                new Apple(200),
                new Apple(250),
                new Apple(150),
                new Orange(200),
                new Orange(250),
                new Orange(150)
        );

        Box<Fruit> box1 = new Box<>(Fruit.class, 1);
        Box<Apple> box2 = new Box<>(Apple.class, 2);
        Box<Orange> box3 = new Box<>(Orange.class, 3);

        for (Fruit fruit : fruits) {
            box1.put(fruit);
            if (fruit instanceof Apple apple) {
                box2.put(apple);
            }
            if (fruit instanceof Orange orange) {
                box3.put(orange);
            }
        }

        try {
            System.out.println(box1);
            System.out.println(box2);
            System.out.println(box3);
            if (box1.compare(box2)) {
                System.out.printf("Коробки с номерами %d и %d равны%n", box1.getNumber(), box2.getNumber());
            }
            if (box1.compare(box3)) {
                System.out.printf("Коробки с номерами %d и %d равны%n", box1.getNumber(), box3.getNumber());
            }
            if (box2.compare(box3)) {
                System.out.printf("Коробки с номерами %d и %d равны%n", box2.getNumber(), box3.getNumber());
            }
            box1.putAllByType(box2);
            System.out.println(box1);
            System.out.println(box2);
            box1.putAllByType(box3);
            System.out.println(box1);
            System.out.println(box3);
            box2.putAllByType(box1);
            System.out.println(box2);
            System.out.println(box1);
            box3.putAllByType(box1);
            System.out.println(box3);
            System.out.println(box1);
            box2.putAllByType(box3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
