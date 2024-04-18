package org.evote.backend.users.precinct.repository;

import org.evote.backend.users.precinct.entity.Precinct;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UsersPrecinctRepository extends JpaRepository<Precinct, Integer> {
}
