package org.evote.backend.votes.precinct.exception;

public class PrecinctNotFoundException extends RuntimeException {
    public PrecinctNotFoundException(String message) {
        super(message);
    }
}
