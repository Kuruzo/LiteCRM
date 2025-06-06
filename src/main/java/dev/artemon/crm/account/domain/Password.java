package dev.artemon.crm.account.domain;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Objects;

public class Password {

    private final String hash;

    public Password(String input) {
        this.hash = BCrypt.hashpw(input, BCrypt.gensalt());
    }

    public boolean matches(String input) {
        return BCrypt.checkpw(input, this.hash);
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

