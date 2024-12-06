package ru.otus.java.basic.homework.hw3;

public class HomeWork {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
        doTask5();
    }

    private static void doTask1() {
        System.out.println("-------- Task 1 (sumOfPositiveElements) --------");
        var array = new int[][]{{1, -16, 8, 2, 4, -12, 5, 3}, {2, 3, 0, 1}, {1}, {3}};
        printArrayOfArray(array, "Исходный массив");
        System.out.println("Сумма всех элементов, которые больше 0, равна: " + sumOfPositiveElements(array));
    }

    private static void doTask2() {
        System.out.println("-------- Task 2 (printSquare) --------");
        printSquare(5, true);
        printSquare(5, false);
    }

    private static void doTask3() {
        System.out.println("-------- Task 3 (setZeroInArrayDiagonals) --------");
        var array = getRandomSquareArray(6);
        System.out.println("Исходный массив");
        printSquareArray(array, false);
        setZeroInArrayDiagonals(array);
        System.out.println("Массив после изменения диагональных значений");
        printSquareArray(array, true);
    }

    private static void doTask4() {
        System.out.println("-------- Task 4 (findMax) --------");
        var array = getRandomSquareArray(6);
        System.out.println("Исходный массив");
        printSquareArray(array, false);
        System.out.println("Максимальное значение элемента в массиве: " + findMax(array));
    }

    private static void doTask5() {
        System.out.println("-------- Task 5 (getSumOfRow getSumOfColumn) --------");
        var array = getRandomSquareArray(6);
//        var array = new int[][]{{1, -16, 8, 2, 4, -12, 5, 3}, {2, 3, 0, 1}, {1}, {3}};
        System.out.println("Исходный массив");
        printSquareArray(array, false);
        System.out.println("Сумма второй строки: " + getSumOfRow(array, 1));
        System.out.println("Сумма второй колонки: " + getSumOfColumn(array, 1));
    }

    private static int sumOfPositiveElements(int[][] arrayOfIntArray) {
        int sum = 0;
        int minItemValue = 0;
        for (int[] intArray : arrayOfIntArray) {
            sum += sumOfItemsMoreThen(intArray, minItemValue);
        }
        return sum;
    }


    private static int findMax(int[][] arrayOfIntArray) {
        int max = findMax(arrayOfIntArray[0]);
        for (int i = 1; i < arrayOfIntArray.length; i++) {
            max = Math.max(max, findMax(arrayOfIntArray[i]));
        }
        return max;
    }

    private static int getSumOfRow(int[][] arrayOfIntArray, int rowIndex) {
        int sum = 0;
        if (rowIndex > (arrayOfIntArray.length - 1))
            return -1;
        for (int i = 0; i < arrayOfIntArray[rowIndex].length; i++) {
//            System.out.print(arrayOfIntArray[rowIndex][i]);
            sum += arrayOfIntArray[rowIndex][i];
        }
        return sum;
    }

    private static int getSumOfColumn(int[][] arrayOfIntArray, int columnIndex) {
        int sum = 0;
        for (int i = 0; i < arrayOfIntArray.length; i++) {
            if (columnIndex > (arrayOfIntArray[i].length - 1))
                return -1;
//            System.out.print(arrayOfIntArray[i][columnIndex]);
            sum += arrayOfIntArray[i][columnIndex];
        }
        return sum;
    }

    private static void printSquare(int size, boolean filled) {
        System.out.println("Квадрат " + size + "x" + size + (filled ? " Заполненный" : " Пустой"));

        String borderSymbol = " * ";
        String innerSymbol = "   ";
        int lastIndex = size - 1;
        for (int i = 0; i < size; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == lastIndex || j == 0 || j == lastIndex || filled) {
                    row.append(borderSymbol);
                } else {
                    row.append(innerSymbol);
                }
            }
            System.out.println(row);
        }
        System.out.println();
    }


    private static int[][] getRandomSquareArray(int size) {
        int[][] squareArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int randomVal = (int) (Math.random() * 10);
                squareArray[i][j] = randomVal;
            }
        }
        return squareArray;
    }

    private static void printSquareArray(int[][] arrayOfIntArray, boolean coloredDiagonals) {
        int secondDiagonalIndexI = 0;
        int secondDiagonalIndexJ = arrayOfIntArray.length - 1;
        for (int i = 0; i < arrayOfIntArray.length; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < arrayOfIntArray[i].length; j++) {
                if (coloredDiagonals && i == j) {
                    row.append(String.format(ANSI_GREEN + " %1d " + ANSI_RESET, arrayOfIntArray[i][j]));
                } else if (coloredDiagonals && i == secondDiagonalIndexI && j == secondDiagonalIndexJ) {
                    row.append(String.format(ANSI_RED + " %1d " + ANSI_RESET, arrayOfIntArray[i][j]));
                } else {
                    row.append(String.format(" %1d ", arrayOfIntArray[i][j]));
                }
            }
            System.out.println(row);
            ++secondDiagonalIndexI;
            --secondDiagonalIndexJ;
        }
        System.out.println();
    }

    private static void setZeroInArrayDiagonals(int[][] arrayOfIntArray) {
        for (int i = 0, secondDiagonalIndexJ = arrayOfIntArray.length - 1; i < arrayOfIntArray.length; i++, secondDiagonalIndexJ--) {
            arrayOfIntArray[i][i] = 0;
            arrayOfIntArray[i][secondDiagonalIndexJ] = 0;
        }
    }

    private static int sumOfItemsMoreThen(int[] intArray, int minItemValue) {
        int sum = 0;
        for (int j : intArray) {
            if (j > minItemValue) {
                sum += j;
            }
        }
//        for (int i = 0; i < intArray.length; i++) {
//            if (intArray[i] > minItemValue) {
//                sum += intArray[i];
//            }
//        }
        return sum;
    }

    private static int findMax(int[] intArray) {
        int max = intArray[0];
        for (int item : intArray) {
            max = Math.max(max, item);
        }
        return max;
    }

    private static void printArray(int[] array, String message) {
        if (!message.equals("")) {
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
        if (!message.equals("")) {
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
}
