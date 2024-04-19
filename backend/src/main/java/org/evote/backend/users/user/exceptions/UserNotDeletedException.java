package org.evote.backend.users.user.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotDeletedException extends RuntimeException {
    private HttpStatus httpStatus;
    public UserNotDeletedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
