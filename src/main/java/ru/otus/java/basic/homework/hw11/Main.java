package ru.otus.java.basic.homework.hw11;

import ru.otus.java.basic.homework.hw11.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var list = new ArrayList<Employee>(List.of(
                new Employee("Stas", 15),
                new Employee("Tom", 10),
                new Employee("Petya", 6),
                new Employee("Ira", 1),
                new Employee("Sveta", 3),
                new Employee("Anya", 8),
                new Employee("Vova", 4),
                new Employee("Tanya", 2),
                new Employee("Kolya", 13),
                new Employee("Dasha", 5),
                new Employee("Dunya", 17),
                new Employee("Rftya", 14),
                new Employee("Vanay", 7)
        ));

        System.out.println("Исходный лист:");
        System.out.println(list);
        var empl = new Employee("Vanay", 16);

        var tree = new Tree<Employee>(list);
        System.out.println("Дерево:");
        tree.print();

        System.out.println("Поиск записи в дереве: " + list.get(2));
        System.out.println("Найдено: " + tree.find(list.get(2)));
        System.out.println("Поиск записи в дереве: " + empl);
        System.out.println("Найдено: " + tree.find(empl));
        System.out.println("Отсортированный лист: ");
        System.out.println(tree.getSortedList());

    }

}
