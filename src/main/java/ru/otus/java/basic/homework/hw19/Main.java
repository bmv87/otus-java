package ru.otus.java.basic.homework.hw19;

import java.util.Scanner;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static final Scanner sc = new Scanner(System.in);
    ;

    public static void main(String[] args) {
        try (FileScanner scanner = new FileScanner("files")) {
            scanner.printFileList();
            scanner.selectFile();
            System.out.printf("%n%sВведите строку для для поиска в выбранном файле или для выхода наберите Q:%s%n", ANSI_GREEN, ANSI_RESET);
            do {
                String strLine = null;

                if (sc.hasNextLine()) {
                    strLine = sc.nextLine();
                }

                if (strLine == null || strLine.isBlank()) {
                    System.out.printf("%n%sНичего не ввели. Попробуйте еще раз.%s%n", ANSI_RED, ANSI_RESET);
                    continue;
                }
                if (strLine.equalsIgnoreCase("Q")) {
                    break;
                }
                int count = scanner.getSubstringCount(strLine);
                System.out.printf("%n%sКоличество найденных вхождений: %d. Введите новую строку или для выхода наберите Q %s%n", ANSI_GREEN, count, ANSI_RESET);
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
