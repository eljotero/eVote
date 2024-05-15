package org.evote.backend.votes.political_party.exception;

public class PoliticalPartyNotFoundException extends RuntimeException {
    public PoliticalPartyNotFoundException(String message) {
        super(message);
    }
}
