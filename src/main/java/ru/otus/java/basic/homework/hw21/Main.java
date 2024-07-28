package ru.otus.java.basic.homework.hw21;


import java.util.Arrays;

public class Main {
    public int[] cutArrayFrom(int[] array, int startValue) {
        var lastValueIndex = lastIndexOf(array, startValue);
        if (lastValueIndex == -1) {
            throw new RuntimeException("Item not found in array");
        }
        if (lastValueIndex == array.length - 1) {
            return null;
        }
        return Arrays.copyOfRange(array, lastValueIndex + 1, array.length - 1);
    }

    public boolean arrayContainsOnly(int[] array, int[] containsValues) {

        return Arrays.stream(containsValues).allMatch(containsVal -> Arrays.stream(array).anyMatch(arrVal -> arrVal == containsVal)) &&
                Arrays.stream(array).allMatch(arrVal -> Arrays.stream(containsValues).anyMatch(containsVal -> arrVal == containsVal));

    }

    private static int lastIndexOf(int[] array, int valueToFind) {
        if (array != null) {
            var startIndex = array.length - 1;

            for (int i = startIndex; i >= 0; --i) {
                if (valueToFind == array[i]) {
                    return i;
                }
            }

            return -1;
        } else {
            return -1;
        }
    }
}
