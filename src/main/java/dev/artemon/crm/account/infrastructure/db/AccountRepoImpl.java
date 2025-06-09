package dev.artemon.crm.account.infrastructure.db;

import dev.artemon.crm.account.domain.Account;
import dev.artemon.crm.account.domain.AccountRepo;
import dev.artemon.crm.shared.Email;
import dev.artemon.crm.account.domain.Password;
import dev.artemon.crm.account.domain.Role;
import dev.artemon.crm.shared.ID;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AccountRepoImpl implements AccountRepo {

    private final JdbcClient jdbc;

    private static final RowMapper<Account> ACCOUNT_ROW_MAPPER = (rs, ignore) -> Account.restore(
            ID.from(rs.getObject("id", UUID.class)),
            Email.fromString(rs.getString("email")),
            Password.fromString(rs.getString("hash")),
            Role.valueOf(rs.getString("role")),
            rs.getBoolean("active")
    );

    @NotNull
    private Optional<Account> findAccountByColumn(String columnName, Object value) {
        return jdbc
                .sql("SELECT * FROM accounts WHERE " + columnName + " = ?")
                .param(value)
                .query(ACCOUNT_ROW_MAPPER)
                .optional();
    }

    @Override
    public Optional<Account> findByEmail(@NotNull Email email) {
        return findAccountByColumn("email", email.value());
    }

    @Override
    public Optional<Account> findById(@NotNull ID<Account> id) {
        return findAccountByColumn("id", id.value());
    }

    @Override
    public List<Account> findAll() {
        return jdbc
                .sql("SELECT * FROM accounts")
                .query(ACCOUNT_ROW_MAPPER)
                .list();
    }

    @Override
    public Account save(@NotNull Account account) {
        return jdbc
                .sql("INSERT INTO accounts (id, email, password, role, active) VALUES (?, ?, ?, ?, ?)")
                .params(account.getId().value(),
                        account.getEmail().value(),
                        account.getPassword().value(),
                        account.getRole().name(),
                        account.isActive()
                ).update() > 0 ? account : null;
    }
}