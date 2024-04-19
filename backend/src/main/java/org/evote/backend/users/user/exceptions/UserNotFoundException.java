package org.evote.backend.users.user.exceptions;

public class UserNotFoundException extends RuntimeException {
    private String errorCode;
    public UserNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
