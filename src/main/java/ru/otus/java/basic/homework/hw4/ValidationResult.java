package ru.otus.java.basic.homework.hw4;

public class ValidationResult {
    private boolean valid;
    private String message;

    public ValidationResult(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void throwIfNotValid() {
        if (!valid) {
            throw new RuntimeException(message != null ? message : "Что-то пошло не так");
        }
    }
}
