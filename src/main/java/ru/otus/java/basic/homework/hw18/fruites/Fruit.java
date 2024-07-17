package ru.otus.java.basic.homework.hw18.fruites;

public abstract class Fruit implements Comparable<Fruit> {

    protected final FruitType type;
    protected final double weight;

    public Fruit(FruitType type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    public FruitType getType() {
        return type;
    }

    public Double getWeight() {
        return weight;
    }

    public int compareTo(Fruit o) {
        var typeComparingResult = this.getType().toString().compareTo(o.getType().toString());
        if (typeComparingResult == 0) {
            return this.getWeight().compareTo(o.getWeight());
        }
        return typeComparingResult;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type=" + type +
                ", weight=" + weight +
                '}';
    }
}
