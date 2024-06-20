package ru.otus.java.basic.homework.hw14;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        int arraySize = 100_000_000;
        doTask1(arraySize);
        doTask2(arraySize, 4);
    }


    public static void doTask1(int arraySize) {
        System.out.printf("Размер массива: %d %n", arraySize);
        double[] array = new double[arraySize];
        long start = System.currentTimeMillis();
        fillArraySequentially(array, 0, array.length - 1);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.printf("Последовательное заполнение массива выполнилось за %d мс %n", timeElapsed);
        if (arraySize <= 30) {
            printArray(array);
        }
    }

    public static void doTask2(int arraySize, int threadCount) {
        System.out.printf("Размер массива: %d %n", arraySize);
        double[] array = new double[arraySize];
        long start = System.currentTimeMillis();
        fillArrayParallel(array, threadCount);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.printf("Параллельное заполнение массива (количество потоков: %d) выполнилось за %d мс %n", threadCount, timeElapsed);
        if (arraySize <= 30) {
            printArray(array);
        }
    }


    public static void fillArraySequentially(double[] array, int startIndex, int endIndex) {
        validateArray(array);
        if (array.length <= startIndex || array.length <= endIndex)
            throw new IllegalArgumentException("Индексы массива указаны неверно");
        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    public static void fillArrayParallel(double[] array, int threadCount) {
        validateArray(array);
        List<Thread> tasks = new ArrayList<>();
        int delta = array.length / threadCount;

        for (int i = 0; i < threadCount; i++) {
            var finalStartIndex = i * delta;
            var finalEndIndex = i == (threadCount - 1)
                    ? array.length - 1
                    : finalStartIndex + delta - 1;
            var task = new Thread(() -> {
                fillArraySequentially(array, finalStartIndex, finalEndIndex);
            });
            task.start();
            tasks.add(task);
        }
        for (Thread task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static void validateArray(double[] array) {
        if (array == null)
            throw new IllegalArgumentException("Массив не задан");
    }

    private static void printArray(double[] array) {

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
        System.out.println();
    }
}
