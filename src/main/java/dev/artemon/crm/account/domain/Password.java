package dev.artemon.crm.account.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Objects;

public class Password {

    private final String hash;

    private Password(String hash) {
        if (hash == null) throw new NullPointerException("Password cannot be null");
        this.hash = hash;
    }

    @NotNull
    @Contract("_ -> new")
    public static Password fromString(@NotNull String plaintext) {
        if (plaintext.length() < 8) throw new IllegalArgumentException("Password must be at least 8 characters long");
        return new Password(BCrypt.hashpw(plaintext, BCrypt.gensalt()));
    }

    @NotNull
    @Contract("_ -> new")
    public static Password fromHash(String hash) {
        return new Password(hash);
    }

    public String value() {
        return this.hash;
    }

    public boolean matches(String plaintext) {
        return BCrypt.checkpw(plaintext, this.hash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password password)) return false;
        return Objects.equals(hash, password.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hash);
    }

    @Override
    public String toString() {
        return "[PRIVATE]";
    }
}

