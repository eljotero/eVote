package org.evote.backend.users.account.exceptions;

public class AccountAuthenticationException extends RuntimeException {
    public AccountAuthenticationException(String message) {
        super(message);
    }
}
