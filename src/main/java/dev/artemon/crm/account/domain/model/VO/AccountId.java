package dev.artemon.crm.account.domain.model.VO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountId {

    @Column(name = "id", unique = true, updatable = false)
    @Getter
    private final UUID value;

    public AccountId() {
        this.value = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountId accountId)) return false;
        return Objects.equals(value, accountId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}