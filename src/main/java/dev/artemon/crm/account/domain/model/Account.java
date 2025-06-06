package dev.artemon.crm.account.domain.model;

import dev.artemon.crm.account.domain.model.VO.AccountId;
import dev.artemon.crm.account.domain.model.VO.Email;
import dev.artemon.crm.account.domain.model.VO.Password;
import dev.artemon.crm.account.domain.model.VO.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PROTECTED)
@Getter
@Table(name = "accounts")
public class Account {

    @EmbeddedId
    private AccountId id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active;

    public Account(Email email, Password password) {
        this.id = new AccountId();
        this.email = email;
        this.password = password;
        this.role = null;
        this.active = true;
    }

    public void activate() {
        if (active) throw new IllegalArgumentException("The Account is active");
        this.active = true;
    }

    public void deactivate() {
        if (!active) throw new IllegalArgumentException("The Account is not active");
        this.active = false;
    }

    public void changeEmail(Email email) {
        this.email = email;
    }

    public void changePassword(Password password) {
        this.password = password;
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
        return "Account{" +
                "id=" + id.getValue() +
                ", email=" + email +
                ", role=" + role +
                ", active=" + active
                + "}";
    }
}