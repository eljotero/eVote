package org.evote.backend.users.user.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {

    }
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
