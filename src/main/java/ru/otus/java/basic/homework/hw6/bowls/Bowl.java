package ru.otus.java.basic.homework.hw6.bowls;

public class Bowl {

    private final int maxFoodVolume;
    private int currentFoodVolume;

    public Bowl(int maxFoodVolume) {
        this.maxFoodVolume = maxFoodVolume;
        this.currentFoodVolume = maxFoodVolume;
    }

    public void putFood(int foodVolume) {
        if (foodVolume < 0) {
            System.out.printf("Неправильно задан объем еды: %d ед.\n", foodVolume);
            return;
        }
        var newFoodVolume = currentFoodVolume + foodVolume;
        currentFoodVolume = Math.min(maxFoodVolume, newFoodVolume);
        if (newFoodVolume > maxFoodVolume) {
            System.out.printf("Миска заполнена. Максимальный объем еды, вмещающийся в эту миску: %d ед. \n", maxFoodVolume);
        }
    }

    public boolean reduceFood(int amount) {
        if (amount < 0) {
            System.out.printf("Неправильно задан объем еды: %d ед.\n", amount);
            return false;
        }
        if (currentFoodVolume < amount) {
            return false;
        }
        currentFoodVolume -= amount;
        return true;
    }
}
