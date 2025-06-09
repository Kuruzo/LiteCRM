package dev.artemon.crm.account.domain;

import dev.artemon.crm.shared.Email;
import dev.artemon.crm.shared.ID;

import java.util.List;
import java.util.Optional;

public interface AccountRepo {

    Account save(Account account);

    Optional<Account> findByEmail(Email email);

    Optional<Account> findById(ID<Account> id);

    List<Account> findAll();
}
