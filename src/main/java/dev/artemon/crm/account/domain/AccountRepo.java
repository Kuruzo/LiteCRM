package dev.artemon.crm.account.domain;

import java.util.List;
import java.util.Optional;

public interface AccountRepo {

    Account save(Account account);

    Optional<Account> findByEmail(Email email);

    Optional<Account> findById(AccountId id);

    List<Account> findAll();
}
