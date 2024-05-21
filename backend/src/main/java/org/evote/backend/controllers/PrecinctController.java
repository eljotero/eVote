package org.evote.backend.controllers;

import org.evote.backend.services.PrecinctService;
import org.evote.backend.users.precinct.entity.Precinct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/precinct")
public class PrecinctController {
    private final PrecinctService precinctService;

    public PrecinctController(PrecinctService precinctService) {
        this.precinctService = precinctService;
    }

    @RequestMapping("/all")
    public List<Precinct> getAllPrecincts() {
        return precinctService.findAllPrecincts();
    }

//    @RequestMapping("/city")
//    public Precinct getPrecinctByCity(@RequestBody PrecinctSetDTO precinctSetDTO) {
//        return precinctService.findPrecinctCity(precinctSetDTO).orElse(null);
//    }
}
