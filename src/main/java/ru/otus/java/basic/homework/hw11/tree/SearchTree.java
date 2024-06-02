package ru.otus.java.basic.homework.hw11.tree;

import java.util.List;

public interface SearchTree <T extends Comparable<T>>{
    T find(T element);
    List<T> getSortedList();
}
