package org.evote.backend.users.account.repositry;

import org.evote.backend.users.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByEmail(String email);

}
