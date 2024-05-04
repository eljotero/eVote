package org.evote.backend.users.account.exceptions;

public class PasswordTooShortException extends RuntimeException {
    public PasswordTooShortException(String message) {
        super(message);
    }
}
