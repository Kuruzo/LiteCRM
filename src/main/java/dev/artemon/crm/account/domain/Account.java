package dev.artemon.crm.account.domain;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class Account {

    private final AccountId id;
    private Email email;
    private Password password;
    private Role role;
    private boolean active;

    public Account(Email email, Password password) {
        this.id = new AccountId(UUID.randomUUID());
        this.email = email;
        this.password = password;
        this.role = null;
        this.active = true;
    }

    public static Account fromData(AccountId id, Email email, Password password, Role role, boolean active) {

    }

    public void changeEmail(Email email) {
        this.email = email;
    }

    public void changePassword(Password password) {
        this.password = password;
    }

    public void changeRole(Role role) {
        this.role = role;
    }

    public void activate() {
        if (active) throw new IllegalArgumentException("The Account is active");
        this.active = true;
    }

    public void deactivate() {
        if (!active) throw new IllegalArgumentException("The Account is not active");
        this.active = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id.value() + ", email=" + email + ", role=" + role + ", active=" + active + "}";
    }
}