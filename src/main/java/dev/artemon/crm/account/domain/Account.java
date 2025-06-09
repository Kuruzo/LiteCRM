package dev.artemon.crm.account.domain;

import dev.artemon.crm.shared.Email;
import dev.artemon.crm.shared.ID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private final ID<Account> id;
    private Email email;
    private Password password;
    private final Role role;
    private boolean active;

    @NotNull
    @Contract("_, _ -> new")
    public static Account createNewAccount(Email email, Password password) {
        return new Account(ID.newId(), email, password, null, true);
    }

    @NotNull
    @Contract(value = "_, _, _, _, _ -> new", pure = true)
    public static Account restore(ID<Account> id, Email email, Password password, Role role, boolean active) {
        return new Account(id, email, password, role, active);
    }

    public void changeEmail(Email email) {
        this.email = email;
    }

    public void changePassword(Password password) {
        this.password = password;
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