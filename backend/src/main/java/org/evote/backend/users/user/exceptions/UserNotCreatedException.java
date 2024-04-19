package org.evote.backend.users.user.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotCreatedException extends RuntimeException {
    private HttpStatus httpStatus;
    public UserNotCreatedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
