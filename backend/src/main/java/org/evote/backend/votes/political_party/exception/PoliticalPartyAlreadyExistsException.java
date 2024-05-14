package org.evote.backend.votes.political_party.exception;

public class PoliticalPartyAlreadyExistsException extends RuntimeException {
    public PoliticalPartyAlreadyExistsException(String message) {
        super(message);
    }
}
