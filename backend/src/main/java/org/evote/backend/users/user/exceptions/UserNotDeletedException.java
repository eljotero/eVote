package org.evote.backend.users.user.exceptions;

public class UserNotDeletedException extends RuntimeException {
    private String errorCode;

    public UserNotDeletedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
