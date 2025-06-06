package dev.artemon.crm.account.infrastructure.db;

import dev.artemon.crm.account.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringJpaRepoImpl extends JpaRepository<Account, UUID> {

    Optional<Account> findByEmail_Value(String string);
}
