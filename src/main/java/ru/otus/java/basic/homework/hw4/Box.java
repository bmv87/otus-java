package ru.otus.java.basic.homework.hw4;

public class Box {
    private String item;
    private ColorsEnum color;
    private final BoxSize size;
    private boolean opened;

    public Box(int width, int height, int depth) throws Exception {
        this.color = ColorsEnum.black;
        this.size = new BoxSize(width, height, depth);
    }

    public Box(int width, int height, int depth, ColorsEnum color) throws Exception {
        this.color = color;
        this.size = new BoxSize(width, height, depth);
    }

    public ColorsEnum getColor() {
        return color;
    }

    public void setColor(ColorsEnum color) {
        this.color = color;
    }

    public void open() {
        if (!opened) {
            opened = true;
            System.out.println("Коробка открыта!");
        } else {
            System.out.println("Коробка уже открыта!");
        }
    }

    public void close() {
        if (opened) {
            opened = false;
            System.out.println("Коробка закрыта!");
        } else {
            System.out.println("Коробка уже закрыта!");
        }
    }

    public boolean putItem(String item) {
        if (item == null || item.isBlank()) {
            System.out.println("Предмет не распознан!");
            return false;
        }
        if (!opened) {
            System.out.println("В закрытую коробку нельзя положить предмет!");
            return false;
        }
        if (this.item != null) {
            System.out.println("В коробке уже есть предмет!");
            return false;
        }
        this.item = item;
        System.out.println("Предмет помещен в коробку!");
        return true;
    }

    public boolean clearItem() {
        if (!opened) {
            System.out.println("Из закрытой коробки нельзя взять предмет!");
            return false;
        }
        if (this.item == null) {
            System.out.println("Коробка уже пустая!");
            return false;
        }

        this.item = null;
        System.out.println("Предмет взят из коробки!");
        return true;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Описание коробки:");
        sb.append(System.lineSeparator());
        sb.append(String.format("Цвет: %s", color.getName()));
        sb.append(System.lineSeparator());
        sb.append(size.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Статус коробки: %s", opened ? "Открыта" : "Закрыта"));
        sb.append(System.lineSeparator());
        sb.append(String.format("Содержимое коробки: %s", item == null ? "пусто" : item));
        sb.append(System.lineSeparator());

        return sb.toString();
    }

}
