package dev.artemon.crm.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Embeddable
public class Password {

    @Column(nullable = false)
    private String hash;

    protected Password() {}

    public Password(String input) {
        this.hash = BCrypt.hashpw(input, BCrypt.gensalt());
    }

    public boolean matches(String input) {
        return BCrypt.checkpw(input, this.hash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Password password)) return false;
        return hash.equals(password.hash);
    }

    @Override
    public int hashCode() {
        return hash.hashCode();
    }

    @Override
    public String toString() {
        return "[PRIVATE]";
    }
}

