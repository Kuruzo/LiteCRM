package dev.artemon.crm.account.infrastructure.db;

import dev.artemon.crm.account.domain.Account;
import dev.artemon.crm.account.domain.AccountId;
import dev.artemon.crm.account.domain.Email;
import dev.artemon.crm.account.domain.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepoImpl implements AccountRepo {

    private final SpringJpaRepoImpl repo;
    private final AccountMapper mapper;

    @Override
    public Optional<Account> findByEmail(Email email) {
        return repo.findByEmail(email.value()).map(mapper::toDomain);
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Optional<Account> findById(AccountId id) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return List.of();
    }
}