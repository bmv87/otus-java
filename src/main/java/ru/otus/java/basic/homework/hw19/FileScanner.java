package ru.otus.java.basic.homework.hw19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public int getSubstringCount(String substring) throws IOException {
        if (currentFile == null) {
            throw new IllegalArgumentException("Файл не выбран.");
        }
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
            do {
                // считаем сначала первую строку
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                Matcher m = Pattern.compile("(?=(" + substring + "))").matcher(line);
                while (m.find()) {
                    count += 1;
                }
            } while (true);
        }
        return count;
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }
}
