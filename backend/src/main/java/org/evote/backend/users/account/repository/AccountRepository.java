package org.evote.backend.users.account.repository;

import org.evote.backend.users.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findById(Integer id);

    Account findByEmail(String email);

}
