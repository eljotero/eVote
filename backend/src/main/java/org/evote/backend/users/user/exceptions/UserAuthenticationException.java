package org.evote.backend.users.user.exceptions;

public class UserAuthenticationException extends RuntimeException {
    public UserAuthenticationException() {
    }
    public UserAuthenticationException(String message) {
        super(message);
    }
}
