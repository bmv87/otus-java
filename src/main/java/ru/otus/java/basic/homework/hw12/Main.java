package ru.otus.java.basic.homework.hw12;

public class Main {
    public static void main(String[] args) {
        try (FileScanner scanner = new FileScanner("files")) {
            scanner.printFileList();
            scanner.selectFile();
            scanner.addContentToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
