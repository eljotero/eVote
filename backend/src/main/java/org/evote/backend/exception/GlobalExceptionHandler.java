package org.evote.backend.exception;

import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=AccountNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleUserNotFoundException(AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }

    @ExceptionHandler(value=AccountAlreadyExistsException.class)
        public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(AccountAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
        }

    @ExceptionHandler(value=AccountAuthenticationException.class)
        public ResponseEntity<ErrorResponse> handleUserAuthenticationException(AccountAuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
        }
}
