package org.evote.backend.votes.candidate.exception;

public class CandidateAlreadyExistsException extends RuntimeException {
    public CandidateAlreadyExistsException(String message) {
        super(message);
    }
}