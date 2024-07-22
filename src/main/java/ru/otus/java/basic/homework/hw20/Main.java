package ru.otus.java.basic.homework.hw20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final Object A = new Object();
    static final Object B = new Object();
    static final Object C = new Object();

    public static void main(String[] args) {
        try (ExecutorService pool = Executors.newFixedThreadPool(3)) {

            pool.execute(() -> {
                try {
                    print('A', 5, C, A);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            pool.execute(() -> {
                try {
                    print('B', 5, A, B);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            pool.execute(() -> {
                try {
                    print('C', 5, B, C);
                    System.out.println();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            pool.shutdown();
        }
    }


    private static void print(char letter, int count, final Object prev, final Object current) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            synchronized (prev) {
                synchronized (current) {
                    System.out.print(letter);
                    current.notifyAll();
                }
                if (i != count - 1) {
                    prev.wait();
                }
            }
        }
    }
}
