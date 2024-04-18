package org.evote.backend.votes.address.repository;

import org.evote.backend.votes.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface VotesAddressRepository extends JpaRepository<Address, Integer> {
}
