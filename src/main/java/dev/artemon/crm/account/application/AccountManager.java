package dev.artemon.crm.account.application;

import dev.artemon.crm.account.domain.model.Account;
import dev.artemon.crm.account.domain.model.VO.Email;
import dev.artemon.crm.account.domain.model.VO.Password;
import dev.artemon.crm.account.domain.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountManager {

    private final AccountRepo repo;

    public Account registerNewAccount(Email email, Password password) {
        if (repo.findByEmail(email).isPresent())
            throw new IllegalArgumentException("The email is reserved");
        return repo.save(new Account(email, password));
    }
}
