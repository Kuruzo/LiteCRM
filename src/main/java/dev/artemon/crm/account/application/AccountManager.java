package dev.artemon.crm.account.application;

import dev.artemon.crm.account.domain.Account;
import dev.artemon.crm.shared.Email;
import dev.artemon.crm.account.domain.Password;
import dev.artemon.crm.account.domain.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountManager {

    private final AccountRepo repo;

    public Account registerNewAccount(Email email, Password password) {
        if (repo.findByEmail(email).isPresent())
            throw new IllegalArgumentException("The email is reserved");
        return repo.save(Account.createNewAccount(email, password));
    }

    public Account authorize(Email email, Password password) {
        return repo.findByEmail(email)
                .filter(account -> account.getPassword().matches(password.value()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
    }
}
