package ru.otus.java.basic.homework.hw2;

public class HomeWork {


    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
        doTask5();
        doTask6();
        doTask7();
        doTask8();
    }

    private static void doTask1() {
        System.out.println("-------- Task 1 (printStringNTimes) --------");
        printStringNTimes("my string", 5);
        System.out.println();
    }

    private static void doTask2() {
        System.out.println("-------- Task 2 (printSumOfItemsMoreThen) --------");
        var array = new int[]{1, 6, 8, 2, 4, 12, 5, 3};
        printArray(array, "Исходный массив");
        printSumOfItemsMoreThen(array, 5);
        System.out.println();
    }

    private static void doTask3() {
        System.out.println("-------- Task 3 (fillArrayItemsWithValue) --------");
        var array = new int[]{1, 6, 8, 2, 4, 12, 5, 3};
        printArray(array, "Исходный массив");
        fillArrayItemsWithValue(array, 5);
        printArray(array, "Массив после присвоения значений элементам");
        System.out.println();
    }

    private static void doTask4() {
        System.out.println("-------- Task 4 (increaseValueOfArrayItems) --------");
        var array = new int[]{1, 6, 8, 2, 4, 12, 5, 3};
        printArray(array, "Исходный массив");
        var delta = 2;
        increaseValueOfArrayItems(array, delta);
        printArray(array, "Массив после увеличения значений элементов на " + delta);
        System.out.println();
    }

    private static void doTask5() {
        System.out.println("-------- Task 5 (compareSumOfArrayHalves) --------");
        var array = new int[]{1, 16, 8, 2, 4, 12, 5, 3};
        printArray(array, "Исходный массив");
        compareSumOfArrayHalves(array);
        System.out.println();
    }

    private static void doTask6() {
        System.out.println("-------- Task 6 (getArrayOfSummOfArraysItems) --------");
        var array = new int[][]{{1, 16, 8, 2, 4, 12, 5, 3}, {2, 3, 7, 1}, {1}, {}};
        printArrayOfArray(array, "Исходный массив");
        printArray(getArrayOfSummOfArraysItems(array), "Новый массив сумм");
        System.out.println();
    }

    private static void doTask7() {
        System.out.println("-------- Task 7 (checkExistsEqualsSumsOfItemsInArray) --------");
        var array = new int[]{1, 1, 1, 3};
        printArray(array, "-- Исходный массив --");
        checkExistsEqualsSumsOfItemsInArray2(array);
        array = new int[]{5, 3, 4, -2};
        printArray(array, "-- Исходный массив --");
        checkExistsEqualsSumsOfItemsInArray2(array);
        array = new int[]{7, 2, 2, 2};
        printArray(array, "-- Исходный массив --");
        checkExistsEqualsSumsOfItemsInArray2(array);
        array = new int[]{9, 4};
        printArray(array, "-- Исходный массив --");
        checkExistsEqualsSumsOfItemsInArray2(array);
        array = new int[]{5};
        printArray(array, "-- Исходный массив --");
        checkExistsEqualsSumsOfItemsInArray2(array);
        System.out.println();
    }

    private static void doTask8() {
        System.out.println("-------- Task 7 (reverseArray) --------");

        var array = new int[]{1, 16, 8, 2, 4, 12, 5, 3};
        printArray(array, "-- Исходный массив --");

        System.out.println("Итерация по массиву");

        reverseArray(array);
        printArray(array, "-- Результат переворота массива --");

        System.out.println("Рекурсивный вызов");

        reverseArrayRecursive(array);
        printArray(array, "-- Результат переворота массива --");

        System.out.println();
    }

    private static void printStringNTimes(String strValue, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(strValue);
        }
    }

    private static void printArray(int[] array, String message) {
        if (!message.isBlank()) {
            System.out.println(message);
        }
        if (array.length == 0) {
            System.out.print("{ }");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("{ ");
            }
            System.out.print(array[i]);
            if (i != (array.length - 1)) {
                System.out.print(", ");
            } else {
                System.out.print(" }");
            }
        }
        if (!message.isBlank()) {
            System.out.println();
        }

    }

    private static void printArrayOfArray(int[][] array, String message) {

        System.out.println(message);
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("{ ");
            }
            printArray(array[i], "");
            if (i != (array.length - 1)) {
                System.out.print(", ");
            } else {
                System.out.print(" }");
            }
        }
        System.out.println();

    }

    private static void printSumOfItemsMoreThen(int[] intArray, int minItemValue) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > minItemValue) {
                sum += intArray[i];
            }
        }
        System.out.println("Сумма элементов, значения которых больше " + minItemValue + " равна:");
        System.out.println(sum);
    }

    private static int[] getArrayOfSummOfArraysItems(int[][] arrayOfIntArrays) {
        var newArray = new int[arrayOfIntArrays.length];
        for (int i = 0; i < arrayOfIntArrays.length; i++) {
            newArray[i] = getSumOfArrayItems(arrayOfIntArrays[i]);
        }
        return newArray;
    }

    private static int getSumOfArrayItems(int[] intArray) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        return sum;
    }

    private static void fillArrayItemsWithValue(int[] intArray, int value) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = value;
        }
    }

    private static void increaseValueOfArrayItems(int[] intArray, int delta) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] += delta;
        }
    }

    private static void compareSumOfArrayHalves(int[] intArray) {
        if (intArray.length == 0) {
            System.out.println("В массиве нет элементов. Невозможно корректное сравнение половин массива.");
            return;
        }
        if (intArray.length % 2 != 0) {
            System.out.println("В массиве нечетное количество элементов. Невозможно корректное сравнение половин массива.");
            return;
        }
        int countInHalf = intArray.length / 2;
        int sumInLeftHalf = 0;
        int sumInRightHalf = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (i < countInHalf) {
                sumInLeftHalf += intArray[i];
            } else {
                sumInRightHalf += intArray[i];
            }
        }
        if (sumInLeftHalf > sumInRightHalf) {
            System.out.println("Сумма левой половины массива больше суммы правой половины " + sumInLeftHalf + " > " + sumInRightHalf);
        } else if (sumInRightHalf > sumInLeftHalf) {
            System.out.println("Сумма правой половины массива больше суммы левой половины " + sumInRightHalf + " > " + sumInLeftHalf);
        } else {
            System.out.println("Сумма левой половины массива равна сумме правой половины " + sumInLeftHalf + " = " + sumInRightHalf);
        }
    }

    private static boolean isSumOfItemsOfSeparatedArrayEquals(int[] intArray, int indexSeparator) {
        int sumInLeftHalf = 0;
        int sumInRightHalf = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (i < indexSeparator) {
                sumInLeftHalf += intArray[i];
            } else {
                sumInRightHalf += intArray[i];
            }
        }
        return sumInRightHalf == sumInLeftHalf;
    }

    private static void checkExistsEqualsSumsOfItemsInArray(int[] intArray) {

        for (int i = 1; i < intArray.length; i++) {
            if (isSumOfItemsOfSeparatedArrayEquals(intArray, i)) {
                System.out.println("Индекс “точки”, в которой сумма левой и правой части равны: " + i);
            }
        }
        System.out.println("В массиве нет “точки”, в которой сумма левой и правой части равны");
    }

    private static void checkExistsEqualsSumsOfItemsInArray2(int[] intArray) {
        var totalSum = getSumOfArrayItems(intArray);
        if (totalSum % 2 != 0) {
            System.out.println("В массиве нет “точки”, в которой сумма левой и правой части равны");
        }
        var halfOfTotalSum = totalSum / 2;
        for (int i = 0; i < intArray.length; i++) {
            halfOfTotalSum -= intArray[i];
            if (halfOfTotalSum == 0) {
                System.out.println("Индекс “точки”, в которой сумма левой и правой части равны: " + (i+1));
                return;
            } else if (halfOfTotalSum < 0) {
                break;
            }
        }
        System.out.println("В массиве нет “точки”, в которой сумма левой и правой части равны");
    }

    private static void reverseArray(int[] intArray) {
        for (int i = 0; i < intArray.length / 2; i++) {
            int secondIndex = intArray.length - i - 1;
            int tempFirstValue = intArray[i];
            intArray[i] = intArray[secondIndex];
            intArray[secondIndex] = tempFirstValue;
        }
    }

    private static void reverseArrayRecursive(int[] intArray) {
        reverseArray(intArray, 0, intArray.length - 1);
    }

    private static void reverseArray(int[] intArray, int firstIndex, int secondIndex) {
        if (firstIndex < secondIndex) {
            int tempFirstValue = intArray[firstIndex];
            intArray[firstIndex] = intArray[secondIndex];
            intArray[secondIndex] = tempFirstValue;
            reverseArray(intArray, ++firstIndex, --secondIndex);
        }
    }
}
