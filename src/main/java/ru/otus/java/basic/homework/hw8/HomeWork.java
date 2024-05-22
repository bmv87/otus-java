package ru.otus.java.basic.homework.hw8;

import ru.otus.java.basic.homework.hw8.exceptions.AppArrayDataException;
import ru.otus.java.basic.homework.hw8.exceptions.AppArraySizeException;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int fixLength = 4;
        String[][] strArray1 = new String[2][fixLength];
        String[][] strArray2 = new String[fixLength][3];
        String[][] strArray3 = new String[fixLength][fixLength];
        String[][] strArray4 = new String[][]{
                new String[fixLength],
                new String[2],
                new String[fixLength],
                new String[fixLength]
        };
        String[][] strArray5 = new String[][]{
                new String[]{
                        "1", "2", "3", "5"
                },
                new String[]{
                        " tt55", "5", " ", null
                },
                new String[]{
                        "", "", "", ""
                },
                new String[]{
                        "", "", "", ""
                },
        };
        String[][] strArray6 = new String[][]{
                new String[]{
                        "0", "12", "1", "3"
                },
                new String[]{
                        "15", "16", "3", "6"
                },
                new String[]{
                        "3", "3", "3", "3"
                },
                new String[]{
                        "2", "3", "5", "8"
                },
        };

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(null, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray1, -1));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray1, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray2, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray3, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray4, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray5, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Сумма элементов массива: %d.%n", sumAllItems(strArray6, fixLength));
        } catch (AppArrayDataException | AppArraySizeException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumAllItems(String[][] strArray, int fixLength) throws AppArraySizeException, AppArrayDataException {
        if (fixLength <= 0) {
            throw new IllegalArgumentException("Размер массива задан некорректно!");
        }
        if (strArray == null) {
            throw new IllegalArgumentException("Массив не задан!");
        }
        if (strArray.length != fixLength || Arrays.stream(strArray).anyMatch(item -> item.length != fixLength)) {
            throw new AppArraySizeException(fixLength);
        }
        int sum = 0;
        for (int i = 0; i < fixLength; i++) {
            for (int j = 0; j < fixLength; j++) {
                String itemValue = strArray[i][j];
                try {
                    sum += Integer.parseInt(itemValue);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(String.format("Неправильное значение в массиве Array[%d][%d] = '%s'", i, j, itemValue));
                }
            }
        }
        return sum;
    }
}
