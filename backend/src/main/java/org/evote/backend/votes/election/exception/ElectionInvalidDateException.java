package org.evote.backend.votes.election.exception;

public class ElectionInvalidDateException extends RuntimeException {
    public ElectionInvalidDateException(String message) {
        super(message);
    }
}
