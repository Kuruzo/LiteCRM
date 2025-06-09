package dev.artemon.crm.manager.domain;

import dev.artemon.crm.account.domain.Account;
import dev.artemon.crm.shared.ID;
import dev.artemon.crm.shared.Name;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Manager {
    private final ID<Manager> id;
    private final ID<Account> accountId;
    private Name name;
    private boolean active;
}
