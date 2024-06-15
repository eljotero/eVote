package org.evote.backend.users.user.exceptions;

public class UserIncompleteDataException extends RuntimeException {
    public UserIncompleteDataException(String message) {
        super(message);
    }
}
