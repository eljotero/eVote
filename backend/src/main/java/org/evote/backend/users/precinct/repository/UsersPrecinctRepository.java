package org.evote.backend.users.precinct.repository;

import org.evote.backend.users.enums.ElectionType;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface UsersPrecinctRepository extends JpaRepository<Precinct, UUID> {

    @Query("SELECT p FROM UsersPrecinct p WHERE :city MEMBER OF p.availableCities AND p.electionType = :electionType")
    Optional<Precinct> findByAvailableCitiesContainsAndElectionType(@Param("city") String city, @Param("electionType") ElectionType electionType);

    @Query("SELECT p FROM UsersPrecinct p WHERE p.address.voivodeship = :voivodeship AND p.electionType = :electionType")
    Optional<Precinct> findByAddressVoivodeship(@Param("voivodeship") String voivodeship, @Param("electionType") ElectionType electionType);

    @Query("SELECT p FROM UsersPrecinct p JOIN p.users u WHERE u.user_id = :userId AND p.precinct_id = :precinctId")
    Optional<Precinct> findByUserIdAndPrecinctId(@Param("userId") UUID userId, @Param("precinctId") Integer precinctId);
}

