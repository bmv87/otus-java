package ru.otus.java.basic.homework.hw18;

import ru.otus.java.basic.homework.hw18.fruites.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Fruit> {
    private final int number;
    private final Class<T> type;
    protected List<T> fruits = new ArrayList<>();

    public Box(Class<T> clazz, int number) {
        this.number = number;
        this.type = clazz;
    }

    public int getNumber() {
        return number;
    }

    public List<T> getFruits() {
        return fruits;
    }

    private void setFruits(List<T> fruits) {
        this.fruits = fruits;
        fruits.sort(Fruit::compareTo);
        System.out.printf("Содержимое коробки №%d изменилось. %n", number);
    }

    public void put(T fruit) {
        fruits.add(fruit);
        fruits.sort(Fruit::compareTo);
        System.out.printf("В коробку №%d добавлен фрукт %s. %n", number, fruit.getType().getDescription());
    }

    /**
     *  Move to current box filtered content from source box
     * @param box source box
     * @param <E> box content type
     */
    public <E extends Fruit> void putAllByType(Box<E> box) {
        var fr = box.getFruits()
                .stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
        fruits.addAll(fr);
        fruits.sort(Fruit::compareTo);

        if (fr.isEmpty()) {
            throw new IllegalArgumentException(String.format("В коробку №%d не могут быть пересыпаны фрукты из коробки №%d. %n", number, box.number));
        } else {
            System.out.printf("В коробку №%d пересыпано фруктов в количестве %d. %n", number, fr.size());
        }
        if (fr.size() == box.getFruits().size()) {
            box.setFruits(new ArrayList<>());
        } else {
            var fruitsBalance = box.getFruits()
                    .stream()
                    .filter(c -> !type.isInstance(c))
                    .collect(Collectors.toList());
            box.setFruits(fruitsBalance);
        }
    }

    public void addFruitsList(List<? extends T> fruits) {
        this.fruits.addAll(fruits);
        fruits.sort(Fruit::compareTo);
        System.out.printf("Содержимое коробки №%d изменилось. %n", number);
    }

    public void moveTo(Box<? super T> box) {
        box.addFruitsList(getFruits());
        fruits.clear();
    }

    public double weight() {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public <E extends Fruit> boolean compare(Box<E> box) {
        return Double.compare(weight(), box.weight()) == 0;
    }

    @Override
    public String toString() {
        return "Box{" +
                "number=" + number +
                ", type=" + type.getSimpleName() +
                ", fruitsCount=" + fruits.size() +
                ", fruits=" + fruits +
                ", weight=" + weight() +
                '}';
    }
}
