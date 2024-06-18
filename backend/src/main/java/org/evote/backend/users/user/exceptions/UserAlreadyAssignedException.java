package org.evote.backend.users.user.exceptions;

public class UserAlreadyAssignedException extends RuntimeException{
    public UserAlreadyAssignedException(String message) {
        super(message);
    }
}
