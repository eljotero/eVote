package org.evote.backend.exception;

import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountAuthenticationException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.evote.backend.votes.candidate.exception.CandidateAlreadyExistsException;
import org.evote.backend.votes.candidate.exception.CandidateNotFoundException;
import org.evote.backend.votes.election.exception.ElectionAlreadyExistsException;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.political_party.exception.PoliticalPartyAlreadyExistsException;
import org.evote.backend.votes.political_party.exception.PoliticalPartyNotFoundException;
import org.evote.backend.votes.precinct.exception.PrecinctNotFoundException;
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

    @ExceptionHandler(value= PasswordTooShortException.class)
        public ResponseEntity<ErrorResponse> handlePasswordTooShortException(PasswordTooShortException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }

    @ExceptionHandler(value= CandidateAlreadyExistsException.class)
        public ResponseEntity<ErrorResponse> handleCandidateAlreadyExistsException(CandidateAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
        }

    @ExceptionHandler(value= CandidateNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleCandidateNotFoundException(CandidateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }

    @ExceptionHandler(value= ElectionAlreadyExistsException.class)
        public ResponseEntity<ErrorResponse> handleElectionAlreadyExistsException(ElectionAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
        }

    @ExceptionHandler(value= ElectionNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleElectionNotFoundException(ElectionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }

    @ExceptionHandler(value= PoliticalPartyAlreadyExistsException.class)
        public ResponseEntity<ErrorResponse> handlePoliticalPartyAlreadyExistsException(PoliticalPartyAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
        }

    @ExceptionHandler(value= PoliticalPartyNotFoundException.class)
        public ResponseEntity<ErrorResponse> handlePoliticalPartyNotFoundException(PoliticalPartyNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }

    @ExceptionHandler(value= PrecinctNotFoundException.class)
        public ResponseEntity<ErrorResponse> handlePrecinctNotFoundException(PrecinctNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
}
