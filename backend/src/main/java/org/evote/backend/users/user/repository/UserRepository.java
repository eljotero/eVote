package org.evote.backend.users.user.repository;

import org.evote.backend.users.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
