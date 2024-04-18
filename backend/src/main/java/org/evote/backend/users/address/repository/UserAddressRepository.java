package org.evote.backend.users.address.repository;

import org.evote.backend.users.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<Address, Integer> {
}
