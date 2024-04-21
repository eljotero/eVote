package org.evote.backend.users.user.repository;

import org.evote.backend.users.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByPersonalIdNumber(Number personalIdNumber);

}
