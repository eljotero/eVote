package org.evote.backend.users.user.exceptions;

public class CodeMismatchException extends RuntimeException {
    public CodeMismatchException(String message) {
        super(message);
    }
}
