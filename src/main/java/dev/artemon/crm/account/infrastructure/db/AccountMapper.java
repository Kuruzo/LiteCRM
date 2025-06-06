package dev.artemon.crm.account.infrastructure.db;

import dev.artemon.crm.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
class AccountMapper {

    public Account toDomain(AccountJpaEntity entity) {
        Account account = new Account(
                new Email(entity.getEmail()),
                new Password(entity.getHash()) // хеш уже готов
        );

        // вручную подставляем поля, которые не входят в конструктор
        ReflectionTestUtils.setField(account, "id", new AccountId(entity.getId())); // если поля final
        account.setRole(entity.getRole());
        account.setActive(entity.isActive());

        return account;
    }

    public AccountJpaEntity toEntity(Account account) {
        AccountJpaEntity entity = new AccountJpaEntity();
        entity.setId(account.getId().value());         // UUID из AccountId
        entity.setEmail(account.getEmail().value());   // строка из Email
        entity.setHash(account.getPassword().hash());  // строка из Password
        entity.setRole(account.getRole());
        entity.setActive(account.isActive());

        return entity;
    }
}
