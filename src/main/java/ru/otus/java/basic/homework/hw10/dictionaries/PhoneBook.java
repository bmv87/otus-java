package ru.otus.java.basic.homework.hw10.dictionaries;

import ru.otus.java.basic.homework.hw10.validation.ArgumentValidationException;
import ru.otus.java.basic.homework.hw10.validation.ValidationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private static final Pattern VALID_PHONE_NUMBER_REGEX =
            Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_NAME_REGEX =
            Pattern.compile("^[a-zA-Zа-яА-Я-]{2,}$", Pattern.CASE_INSENSITIVE);
    private final Map<String, List<String>> items = new HashMap<>();

    public void add(String name, String phoneNumber) {
        isValidName(name).throwIfNotValid();
        isValidPhoneNumber(phoneNumber).throwIfNotValid();
        var key = name.trim().toLowerCase();
        if (items.containsKey(key)) {
            var item = items.get(key);
            phoneNumber = phoneNumber.trim();
            if (!item.contains(phoneNumber)) {
                var newPholeList = new ArrayList<String>(item);
                newPholeList.add(phoneNumber);
                items.put(key, newPholeList);
            }
        } else {
            items.put(key, new ArrayList<>(List.of(phoneNumber)));
        }
    }

    public void add(String name, List<String> phoneNumbers) {
        isValidName(name).throwIfNotValid();
        if (phoneNumbers == null || phoneNumbers.isEmpty()) {
            throw new ArgumentValidationException("Номер телефона не указан");
        }
        for (String phoneNumber : phoneNumbers) {
            isValidPhoneNumber(phoneNumber).throwIfNotValid();
        }
        var key = name.trim().toLowerCase();

        if (items.containsKey(key)) {
            var item = items.get(key);
            var newPholeList = new ArrayList<String>();
            newPholeList.addAll(item);
            newPholeList.addAll(phoneNumbers);
            items.put(key, newPholeList.stream().map(String::trim).distinct().toList());
        } else {
            items.put(key, phoneNumbers.stream().map(String::trim).distinct().toList());
        }
    }

    public List<String> find(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        var key = name.trim().toLowerCase();
        return items.get(key);
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber).isValid()) {
            return false;
        }
        phoneNumber = phoneNumber.trim();
        for (Map.Entry<String, List<String>> item : items.entrySet()) {
            if (item.getValue().contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private ValidationResult isValidPhoneNumber(String phoneNumber) {
        var result = new ValidationResult(true);
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber + "");
        boolean isValid = matcher.matches();
        if (phoneNumber == null || phoneNumber.isBlank()) {
            result.setValid(false);
            result.setMessage("Номер телефона является обязательным.");
        } else if (!isValid) {
            result.setValid(false);
            result.setMessage("Некорректный номер телефона");
        }
        return result;
    }

    private ValidationResult isValidName(String name) {
        var result = new ValidationResult(true);
        Matcher matcher = VALID_NAME_REGEX.matcher(name + "");
        boolean isValid = matcher.matches();
        if (name == null || name.isBlank()) {
            result.setValid(false);
            result.setMessage("Имя является обязательным.");
        } else if (name.length() < 2) {
            result.setValid(false);
            result.setMessage("Имя должно содержать не менее 2 символов.");
        } else if (!isValid) {
            result.setValid(false);
            result.setMessage("Допустимые символы в имени: a-zA-Zа-яА-Я-");
        }
        return result;
    }
}
