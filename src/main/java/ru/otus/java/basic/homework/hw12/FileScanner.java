package ru.otus.java.basic.homework.hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class FileScanner implements Closeable {
    private final Scanner sc;
    private final File directory;
    private File currentFile;

    public FileScanner(String dirPath) {
        if (dirPath == null)
            throw new IllegalArgumentException("Директория не задана.");
        directory = new File(dirPath);
        if (!directory.exists())
            throw new IllegalArgumentException("Директория не существует. " + directory.getPath());
        if (!directory.isDirectory())
            throw new IllegalArgumentException("Неправильный путь к директории.");
        sc = new Scanner(System.in);
    }

    public void printFileList() {
        System.out.printf("Список файлов в папке %s: %n", directory.getName());
        for (String fileName : Objects.requireNonNull(directory.list())) {
            System.out.println(fileName);
        }
    }

    public void selectFile() {
        System.out.println("Введите наименование файла, который хотите использовать:");
        do {

            String fileName = null;
            if (sc.hasNextLine()) {
                fileName = sc.nextLine();
            }

            if (fileName == null || fileName.isBlank()) {
                System.out.println("Имя файла не задано! Попробуйте еще раз.");
                continue;
            }

            File file = new File(directory.getPath() + File.separator + fileName);
            if (!file.exists() || !file.isFile()) {
                System.out.println("Файл не существует! Попробуйте еще раз.");
                continue;
            }
            currentFile = file;
            break;
        } while (true);
        printFileContent();
    }

    private void printFileContent() {
        try (InputStreamReader bis = new InputStreamReader(new FileInputStream(currentFile), StandardCharsets.UTF_8)) {
            int i;

            while ((i = bis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addContentToFile() {
        if (currentFile == null) {
            throw new IllegalArgumentException("Файл не выбран.");
        }
        try (BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(currentFile, true))) {
            System.out.printf("%nВведите строку для записи в выбранный файл или для выхода наберите Q:%n");
            do {
                String strLine = null;

                if (sc.hasNextLine()) {
                    strLine = sc.nextLine();
                }

                if (strLine == null || strLine.isBlank()) {
                    System.out.println("Ничего не ввели. Попробуйте еще раз.");
                    continue;
                }
                if (strLine.equalsIgnoreCase("Q")) {
                    break;
                }
                byte[] buf = (strLine + System.lineSeparator()).getBytes(StandardCharsets.UTF_8);
                for (int i = 0; i < buf.length; i++) {
                    bis.write(buf[i]);
                }
                System.out.println("Строка добавлена в файл. Введите новую строку или для выхода наберите Q");
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Новое содержимое файла " + currentFile.getPath());
        printFileContent();
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }
}