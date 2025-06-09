package dev.artemon.crm.shared;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private final String value;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9](\\.?[a-zA-Z0-9_+\\-])*" +
                    "@[a-zA-Z0-9](\\.?[a-zA-Z0-9\\-])*\\.[a-zA-Z]{2,}$"
    );

    private Email(String value) {
        if (value == null) throw new NullPointerException("Email cannot be null");
        if (!EMAIL_PATTERN.matcher(value).matches()) throw new IllegalArgumentException("Invalid email: " + value);
        this.value = value.toLowerCase(Locale.ROOT);
    }

    public String value() {
        return value;
    }

    @NotNull
    @Contract("_ -> new")
    public static Email fromString(String email) {
        return new Email(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email email)) return false;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}