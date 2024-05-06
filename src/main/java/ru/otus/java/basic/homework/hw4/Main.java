package ru.otus.java.basic.homework.hw4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        doTask1();
        doTask2();
    }

    private static void doTask2() {
        System.out.println("--------- Task 1 (Box) ----------");
        try {
            var box = new Box(20, 20, 20);
            System.out.println(box.getInfo());
            box.setColor(ColorsEnum.GREEN);
            box.putItem("золото");
            box.clearItem();
            box.open();
            box.clearItem();
            box.putItem("алмазы");
            System.out.println(box.getInfo());
            box.clearItem();
            box.close();
            box = new Box(0, 20, 20);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doTask1() {
        System.out.println("--------- Task 1 (Users) ----------");
        try {
            User[] users = new User[]{
                    null,
                    new User("Smith", "Jone", "Albertovich", 1980, "Smith@dd.ru"),
                    new User("Smith", "Jone", "Vladimirovich", 1956, "Smith1@dd.ru"),
                    new User("Smith", "Jone", null, 1988, "Smith2@dd.ru"),
                    new User("Иванов", "Иван", "Иванович", 1990, "Smith3@dd.ru"),
                    new User("Петров", "Василий", "Александрович", 2000, "Smith4@dd.ru"),
                    new User("Сидоров", "Павел", "Станисловович", 2020, "Smith5@dd.ru"),
                    new User("Smith", "Benjamin", null, 1978, "Smith6@dd.ru"),
                    new User("Smith", "Carter", "Albertovich", 1953, "Smith7@dd.ru"),
                    new User("Smith", "Emily", null, 1982, "Smith8@dd.ru"),
                    new User("Smith", "Jane", "Albertovich", 1991, "Smith9@dd.ru")
            };

            LocalDate date = LocalDate.now();
            int currentYear = date.getYear();
            int maxYear = currentYear - 40;
            for (User user : users) {
                if (user != null && user.getBirthYear() < maxYear) {
                    System.out.println(user.toString());
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
