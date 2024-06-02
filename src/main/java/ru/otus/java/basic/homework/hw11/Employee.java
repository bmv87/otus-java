package ru.otus.java.basic.homework.hw11;

public class Employee implements Comparable<Employee>{
   private final Integer rank;
   private final String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getRank() {
        return rank;
    }

    public Employee(String name, int grade) {
        this.name = name;
        this.rank = grade;
    }

    @Override
    public int compareTo(Employee o) {
        return this.rank.compareTo(o.getRank());
    }
}
