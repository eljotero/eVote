package org.evote.backend.users.user.exceptions;

public class UserNotCreatedException extends RuntimeException {
    private String errorCode;
    public UserNotCreatedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
