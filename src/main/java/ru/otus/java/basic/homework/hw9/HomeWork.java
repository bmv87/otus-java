package ru.otus.java.basic.homework.hw9;

import ru.otus.java.basic.homework.hw9.employees.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
        doTask5();
        doTask6();
        doTask7();
        doTask8();
    }

    private static void doTask1() {
        System.out.println("-------------- Task1 (getSequentialValuesList) ---------------");
        System.out.printf("min = %d; max = %d %n", 3, 8);
        System.out.println(getSequentialValuesList(3, 8));
    }

    private static void doTask2() {
        System.out.println("-------------- Task2 (getSumOfFilteredItems) ---------------");
        var list = getSequentialValuesList(3, 8);
        list.add(1, null);
        System.out.println("Исходный лист:");
        System.out.println(list);
        var min = 5;
        System.out.printf("Сумма всех чисел, которые больше %d: %d %n", min, getSumOfFilteredItems(list, min));
    }

    private static void doTask3() {
        System.out.println("-------------- Task3 (setAllItems) ---------------");
        var list = getSequentialValuesList(2, 9);
        list.add(3, null);
        System.out.println("Исходный лист:");
        System.out.println(list);
        System.out.println("Результат:");
        System.out.println(setAllItems(list, 22));
    }

    private static void doTask4() {
        System.out.println("-------------- Task4 (increaseAllItems) ---------------");
        var list = getSequentialValuesList(10, 18);
        list.add(3, null);
        System.out.println("Исходный лист:");
        System.out.println(list);
        System.out.println("Результат:");
        System.out.println(increaseAllItems(list, 1));
    }

    private static void doTask5() {
        System.out.println("-------------- Task5 (getEmployeesNames) ---------------");
        var list = new ArrayList<Employee>(Arrays.asList(
                new Employee("Volodya", 33),
                new Employee("Tolya", 20),
                null,
                new Employee("Slava", 25),
                new Employee("Kolya", 27),
                new Employee("Danya", 35),
                new Employee("Sveta", 44)
        ));
        System.out.println("Исходный лист:");
        System.out.println(list);
        System.out.println("Результат:");
        System.out.println(getEmployeesNames(list));
        System.out.println("getEmployeesNamesStreamApi:");
        System.out.println(getEmployeesNamesStreamApi(list));
    }

    private static void doTask6() {
        System.out.println("-------------- Task6 (getEmployeesOlderMinAge) ---------------");
        var list = new ArrayList<Employee>(Arrays.asList(
                new Employee("Volodya", 33),
                new Employee("Tolya", 20),
                null,
                new Employee("Slava", 25),
                new Employee("Kolya", 27),
                new Employee("Danya", 35),
                new Employee("Sveta", 44)
        ));
        System.out.println("Исходный лист:");
        System.out.println(list);
        var minAge = 27;
        System.out.printf("Результат для возраста %d:%n", minAge);
        System.out.println(getEmployeesOlderMinAge(list, minAge));
        System.out.println("getEmployeesOlderMinAgeStreamApi:");
        System.out.println(getEmployeesOlderMinAgeStreamApi(list, minAge));
    }

    private static void doTask7() {
        System.out.println("-------------- Task7 (isAverageAgeMoreOrEqualsMinValue) ---------------");
        var list = new ArrayList<Employee>(Arrays.asList(
                new Employee("Volodya", 33),
                new Employee("Tolya", 20),
                null,
                new Employee("Slava", 25),
                new Employee("Kolya", 27),
                new Employee("Danya", 35),
                new Employee("Sveta", 44)
        ));
        System.out.println("Исходный лист:");
        System.out.println(list);
        var minAge = 32;
        System.out.printf("Результат для возраста %d:%n", minAge);
        System.out.printf("Средний возраст не ниже %d: %b %n", minAge, isAverageAgeMoreOrEqualsMinValue(list, minAge));
        System.out.println("isAverageAgeMoreOrEqualsMinValueStreamApi:");
        System.out.printf("Средний возраст не ниже %d: %b %n", minAge, isAverageAgeMoreOrEqualsMinValueStreamApi(list, minAge));
    }

    private static void doTask8() {
        System.out.println("-------------- Task8 (getMostYoungerEmployee) ---------------");
        var list = new ArrayList<Employee>(Arrays.asList(
                new Employee("Volodya", 33),
                new Employee("Tolya", 20),
                null,
                new Employee("Slava", 25),
                new Employee("Kolya", 27),
                new Employee("Danya", 35),
                new Employee("Sveta", 44)
        ));
        System.out.println("Исходный лист:");
        System.out.println(list);
        System.out.println("Самый молодой сотрудник: ");
        System.out.println(getMostYoungerEmployee(list));
        System.out.println("getMostYoungerEmployeeStreamApi:");
        System.out.println(getMostYoungerEmployeeStreamApi(list));
    }


    private static List<Integer> getSequentialValuesList(int min, int max) {
        if (min > max)
            throw new IllegalArgumentException("Минимальное значение больше максимального!");
        var list = new ArrayList<Integer>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    private static <T> void nullValidation(List<T> list) {
        if (list == null)
            throw new IllegalArgumentException("Список не может быть пустым!");
    }

    private static int getSumOfFilteredItems(List<Integer> list, int min) {
        nullValidation(list);
        int sum = 0;
        for (Integer i : list) {
            if (i != null && i > min)
                sum += i;
        }
        return sum;
    }

    private static List<Integer> setAllItems(List<Integer> list, int newValue) {
        nullValidation(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                list.set(i, newValue);
        }
        return list;
    }

    private static List<Integer> increaseAllItems(List<Integer> list, int delta) {
        nullValidation(list);
        for (int i = 0; i < list.size(); i++) {
            var currentValue = list.get(i);
            if (currentValue != null)
                list.set(i, currentValue + delta);
        }
        return list;
    }

    private static List<String> getEmployeesNames(List<Employee> list) {
        nullValidation(list);

        var namesList = new ArrayList<String>();
        for (Employee employee : list) {
            if (employee != null)
                namesList.add(employee.getName());
        }
        return namesList;
    }

    private static List<String> getEmployeesNamesStreamApi(List<Employee> list) {
        nullValidation(list);

        return list.stream().filter(Objects::nonNull).map(Employee::getName).toList();
    }

    private static List<Employee> getEmployeesOlderMinAge(List<Employee> list, int minAge) {
        nullValidation(list);
        var newList = new ArrayList<Employee>();
        for (Employee employee : list) {
            if (employee != null && employee.getAge() >= minAge)
                newList.add(employee);
        }
        return newList;
    }

    private static List<Employee> getEmployeesOlderMinAgeStreamApi(List<Employee> list, int minAge) {
        nullValidation(list);
        return list.stream().filter(e -> e != null && e.getAge() >= minAge).toList();
    }


    private static void checkInputParams(List<Employee> list, int minAverageAge) {
        nullValidation(list);
        if (minAverageAge <= 0)
            throw new IllegalArgumentException("Возраст не указан!");
    }

    private static boolean isAverageAgeMoreOrEqualsMinValue(List<Employee> list, int minAverageAge) {
        checkInputParams(list, minAverageAge);

        var sum = 0;
        var count = 0;
        for (Employee employee : list) {
            if (employee == null) {

                continue;
            }
            sum += employee.getAge();
            ++count;
        }
        var averageAge = count > 0 ? sum / count : 0;
        System.out.printf("Средний возраст: %d %n", averageAge);

        return averageAge >= minAverageAge;
    }

    private static boolean isAverageAgeMoreOrEqualsMinValueStreamApi(List<Employee> list, int minAverageAge) {
        checkInputParams(list, minAverageAge);
        var onlyEmplList = list.stream().filter(Objects::nonNull).toList();
        var averageAge = onlyEmplList.isEmpty()
                ? 0
                : onlyEmplList.stream().mapToInt(Employee::getAge).sum() / onlyEmplList.size();
        System.out.printf("Средний возраст: %d %n", averageAge);
        return averageAge >= minAverageAge;
    }

    private static Employee getMostYoungerEmployee(List<Employee> list) {
        nullValidation(list);

        list.sort(Comparator.nullsLast(Comparator.comparing(Employee::getAge)));

        for (Employee employee : list) {
            if (employee == null)
                continue;
            return employee;
        }
        return null;
    }

    private static Employee getMostYoungerEmployeeStreamApi(List<Employee> list) {
        nullValidation(list);

        return list.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }
}
