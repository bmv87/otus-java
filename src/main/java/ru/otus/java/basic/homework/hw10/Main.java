package ru.otus.java.basic.homework.hw10;

import ru.otus.java.basic.homework.hw10.dictionaries.PhoneBook;
import ru.otus.java.basic.homework.hw10.validation.ArgumentValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var phoneBook = new PhoneBook();
        fillBook(phoneBook);

        System.out.println("Телефонные номера Mary:");
        System.out.println(phoneBook.find("Mary"));
        System.out.println("Телефонные номера Sveta:");
        System.out.println(phoneBook.find("Sveta"));
        System.out.println("Телефонные номера Tanya:");
        System.out.println(phoneBook.find("Tanya"));

        System.out.println(phoneBook.containsPhoneNumber("+98127657573") ? "+98127657573 найден в справочнике" : "+98127657573 не найден в справочнике");
        System.out.println(phoneBook.containsPhoneNumber("+98127655555") ? "+98127655555 найден в справочнике" : "+98127655555 не найден в справочнике");
    }


    private static void fillBook(PhoneBook phoneBook) {
        Map<String, List<String>> items = Map.of(
                "Mary", new ArrayList<>(List.of("76766886", "+7(812)7657573", "+7(812)7657573")),
                "Valera", new ArrayList<>(List.of("76766886", "+7(812)7657573")),
                "Vera", new ArrayList<>(List.of("+98127655555")),
                "Sonya", new ArrayList<>(List.of("+98127657573")),
                "Sonya7474", new ArrayList<>(List.of("+98127655555")),
                "Tanya", new ArrayList<>(),
                "Katya", new ArrayList<>(List.of("777566uytuytv", "+7(812)7657573")),
                "Vasya", new ArrayList<>(List.of("", "+7(812)7657573")),
                "Sveta", new ArrayList<>(List.of("57768693", "+7(812)7657573"))
        );
        for (var item : items.entrySet()) {
            try {
                if (item.getValue().size() == 1) {
                    phoneBook.add(item.getKey(), item.getValue().get(0));
                } else {
                    phoneBook.add(item.getKey(), item.getValue());
                }
            } catch (ArgumentValidationException e) {
                System.out.println("Произошла ошибка проверки входных данных: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошло что-то непредвиденное: " + e.getMessage());
            }
        }
        phoneBook.add("Mary", new ArrayList<>(List.of("9968573222", "+445465165", "+7(812)7657573")));
        phoneBook.add("Mary", "9968573222");
        phoneBook.add("Mary", "996857333");
    }
}
