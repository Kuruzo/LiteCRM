package dev.artemon.crm.account.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringJpaRepoImpl extends JpaRepository<AccountJpaEntity, UUID> {
    Optional<AccountJpaEntity> findByEmail(String string);
}
