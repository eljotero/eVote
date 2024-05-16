package org.evote.backend.users.user.exceptions;

public class CodeAlreadySent extends RuntimeException {
    public CodeAlreadySent(String message) {
        super(message);
    }
}
