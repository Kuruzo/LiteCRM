package dev.artemon.crm.account.domain;

import java.util.regex.Pattern;

public record Email(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-z0-9][a-z0-9._%+-]{0,63}@[a-z0-9.-]+\\.[a-z]{2,}$");

    public Email {
        if (value == null)
            throw new NullPointerException("Email cannot be null");
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email: " + value);
        }
    }
}