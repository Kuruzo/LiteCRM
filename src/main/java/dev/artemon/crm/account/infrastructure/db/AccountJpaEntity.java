package dev.artemon.crm.account.infrastructure.db;

import dev.artemon.crm.account.domain.Role;

import java.util.UUID;

@jakarta.persistence.Entity
@lombok.Data
@jakarta.persistence.Table(name = "accounts")
public class AccountJpaEntity {
    @jakarta.persistence.Id
    private UUID id;
    private String email;
    private String hash;
    private Role role;
    private boolean active;

    protected AccountJpaEntity() {}
}
