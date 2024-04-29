package ru.otus.java.basic.homework.hw1;

import java.util.Scanner;

public class HomeWork {
    static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        int number;
        do {
            System.out.println("Ввведите номер задания (1-5):");
            number = sc.nextInt();
        } while (startTask(number));
    }

    //region private
    private static boolean startTask(int number) {
        switch (number) {
            case (1):
                doTask1();
                return true;
            case (2):
                doTask2();
                return true;
            case (3):
                doTask3();
                return true;
            case (4):
                doTask4();
                return true;
            case (5):
                doTask5();
                return true;
            default:
                System.out.println("Некорректный номер задачи");
                return false;
        }
    }

    private static void doTask1() {
        System.out.println("-------- Task 1 (greetings) --------");
        greetings(new String[]{"Hello", "World", "from", "Java"});
    }

    private static void doTask2() {
        System.out.println("-------- Task 2 (checkSign) --------");
        System.out.println("Ввведите целочисленные значения:");
        System.out.print("a=");
        var a = sc.nextInt();
        System.out.print("b=");
        var b = sc.nextInt();
        System.out.print("c=");
        var c = sc.nextInt();
        checkSign(a, b, c);
    }

    private static void doTask3() {
        System.out.println("-------- Task 3 (selectColor) --------");
        System.out.println("Ввведите целочисленные значения для отображения цвета:");
        var data = sc.nextInt();
        selectColor(data);
    }

    private static void doTask4() {
        System.out.println("-------- Task 4 (compareNumbers) --------");
        System.out.println("Ввведите целочисленные значения:");
        System.out.print("a=");
        var a = sc.nextInt();
        System.out.print("b=");
        var b = sc.nextInt();
        compareNumbers(a, b);
    }

    private static void doTask5() {
        System.out.println("-------- Task 5 (addOrSubtractAndPrint) --------");
        System.out.println("Ввведите целочисленные значения:");
        System.out.print("initValue=");
        var a = sc.nextInt();
        System.out.print("delta=");
        var b = sc.nextInt();
        addOrSubtractAndPrint(a, b, true);
        addOrSubtractAndPrint(a, b, false);

    }

    private static void greetings(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
//
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }
    }

    private static void checkSign(int a, int b, int c) {
        var sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void selectColor(int data) {
        if (data <= 10) {
            System.out.println(ANSI_RED + "Красный" + ANSI_RESET);
        } else if (data <= 20) {
            System.out.println(ANSI_YELLOW + "Желтый" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Зеленый" + ANSI_RESET);
        }
    }

    private static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("increment = " + increment);
        if (increment) {
            System.out.println("initValue + delta = " + (initValue + delta));
        } else {
            System.out.println("initValue - delta = " + (initValue - delta));
        }
    }
    //endregion
}