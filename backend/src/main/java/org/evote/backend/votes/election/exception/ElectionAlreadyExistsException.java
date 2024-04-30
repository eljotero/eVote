package org.evote.backend.votes.election.exception;

public class ElectionAlreadyExistsException extends RuntimeException {
    public ElectionAlreadyExistsException(String message) {
        super(message);
    }
}