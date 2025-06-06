package dev.artemon.crm.account.domain.repo;

import dev.artemon.crm.account.domain.model.Account;
import dev.artemon.crm.account.domain.model.VO.Email;

import java.util.Optional;

public interface AccountRepo {

    Optional<Account> findByEmail(Email email);

    Account save(Account account);
}
