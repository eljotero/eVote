package org.evote.backend.votes.candidate.exception;

public class CandidateWrongPrecinctException extends RuntimeException {
    public CandidateWrongPrecinctException(String message) {
        super(message);
    }
}
