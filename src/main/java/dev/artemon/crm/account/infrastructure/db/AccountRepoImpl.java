package dev.artemon.crm.account.infrastructure.db;

import dev.artemon.crm.account.domain.model.Account;
import dev.artemon.crm.account.domain.model.VO.Email;
import dev.artemon.crm.account.domain.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepoImpl implements AccountRepo {

    private final SpringJpaRepoImpl repo;

    @Override
    public Optional<Account> findByEmail(Email email) {
        return repo.findByEmail_Value(email.toString());
    }

    @Override
    public Account save(Account account) {
        return repo.save(account);
    }
}
