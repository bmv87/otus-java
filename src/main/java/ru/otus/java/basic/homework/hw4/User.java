package ru.otus.java.basic.homework.hw4;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Optional.ofNullable;

public class User {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_NAME_REGEX =
            Pattern.compile("^[a-zA-Zа-яА-Я-]{2,}$", Pattern.CASE_INSENSITIVE);

    private String surname;
    private String name;
    private String patronymic;
    private int birthYear;
    private String email;


    public User() {
    }

    public User(String surname, String name, String patronymic, int birthYear, String email) {

        isValidPartOfName(surname).throwIfNotValid();
        isValidPartOfName(name).throwIfNotValid();
        isValidBirthYear(birthYear).throwIfNotValid();
        isValidEmail(email).throwIfNotValid();

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        var result = isValidPartOfName(surname);
        if (result.isValid()) {
            this.surname = surname;
        } else {
            System.out.println(result.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        var result = isValidPartOfName(name);
        if (result.isValid()) {
            this.name = name;
        } else {
            System.out.println(result.getMessage());
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        var result = isValidBirthYear(birthYear);
        if (result.isValid()) {
            this.birthYear = birthYear;
        } else {
            System.out.println(result.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        var result = isValidEmail(email);
        if (result.isValid()) {
            this.email = email;
        } else {
            System.out.println(result.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("ФИО: %s %s %s", ofNullable(surname).orElse("-"), ofNullable(name).orElse("-"), ofNullable(patronymic).orElse("-")));
        sb.append(System.lineSeparator());
        sb.append(String.format("Год рождения: %d", birthYear));
        sb.append(System.lineSeparator());
        sb.append(String.format("e-mail: %s", ofNullable(email).orElse("-")));
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    private ValidationResult isValidEmail(String email) {
        var result = new ValidationResult(true);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        boolean isValid = matcher.matches();
        if (!isValid) {
            result.setValid(false);
            result.setMessage("Некорректный email");
        }
        return result;
    }

    private ValidationResult isValidBirthYear(int birthYear) {
        var result = new ValidationResult(true);

        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int minimalYear = currentYear - 130;
        boolean isValid = birthYear <= currentYear && birthYear >= minimalYear;
        if (!isValid) {
            result.setValid(false);
            result.setMessage("Некорректный год рождения.  Доступные значения находятся в диапазоне " + minimalYear + "-" + currentYear);
        }
        return result;
    }


    private ValidationResult isValidPartOfName(String partOfName) {
        var result = new ValidationResult(true);
        Matcher matcher = VALID_NAME_REGEX.matcher(partOfName + "");
        boolean isValid = matcher.matches();
        if (partOfName == null || partOfName.isBlank()) {
            result.setValid(false);
            result.setMessage("Имя и Фамилия являются обязательными полями.");
        } else if (partOfName.length() < 2) {
            result.setValid(false);
            result.setMessage("Имя и Фамилия должны содержать не менее 2 символов.");
        } else if (!isValid) {
            result.setValid(false);
            result.setMessage("Допустимые символы в имени и фамилии: a-zA-Zа-яА-Я-");
        }
        return result;
    }

}
