package org.evote.backend.services;

import org.evote.backend.users.enums.ElectionType;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.precinct.repository.UsersPrecinctRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecinctService {

    private final UsersPrecinctRepository usersPrecinctRepository;

    public PrecinctService(UsersPrecinctRepository usersPrecinctRepository) {
        this.usersPrecinctRepository = usersPrecinctRepository;
    }

    public List<Precinct> findAllPrecincts() {
        return usersPrecinctRepository.findAll();
    }

    public Optional<Precinct> findPrecinctCity(String city, ElectionType electionType) {
        return usersPrecinctRepository.findByAvailableCitiesContainsAndElectionType(city, electionType);
    }

    public Optional<Precinct> findPrecinctEuro(String voivodeship, ElectionType electionType) {
        return usersPrecinctRepository.findByAddressVoivodeship(voivodeship, electionType);
    }

}
