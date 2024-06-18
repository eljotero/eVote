package org.evote.backend.exception;

import org.evote.backend.users.account.exceptions.*;
import org.evote.backend.users.user.exceptions.*;
import org.evote.backend.votes.candidate.exception.CandidateAlreadyExistsException;
import org.evote.backend.votes.candidate.exception.CandidateNotFoundException;
import org.evote.backend.votes.candidate.exception.CandidateWrongPrecinctException;
import org.evote.backend.votes.election.exception.ElectionAlreadyExistsException;
import org.evote.backend.votes.election.exception.ElectionInvalidDateException;
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

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(AccountNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(value = AccountAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(AccountAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = AccountAuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleUserAuthenticationException(AccountAuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
    }

    @ExceptionHandler(value = PasswordTooShortException.class)
    public ResponseEntity<ErrorResponse> handlePasswordTooShortException(PasswordTooShortException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(value = ExpiredTokenException.class)
    public ResponseEntity<ErrorResponse> handleExpiredTokenException(ExpiredTokenException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
    }

    @ExceptionHandler(value = UserAlreadyVotedException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyVotedException(UserAlreadyVotedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(value = UserIncompleteDataException.class)
    public ResponseEntity<ErrorResponse> handleUserIncompleteDataException(UserIncompleteDataException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage()));
    }

    @ExceptionHandler(value = CandidateAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCandidateAlreadyExistsException(CandidateAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = CandidateNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCandidateNotFoundException(CandidateNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(value = ElectionAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleElectionAlreadyExistsException(ElectionAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = ElectionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleElectionNotFoundException(ElectionNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(value = PoliticalPartyAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlePoliticalPartyAlreadyExistsException(PoliticalPartyAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = PoliticalPartyNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePoliticalPartyNotFoundException(PoliticalPartyNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(value = PrecinctNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePrecinctNotFoundException(PrecinctNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(value = CodeAlreadySent.class)
    public ResponseEntity<ErrorResponse> handleCodeAlreadySent(CodeAlreadySent e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = UserAlreadyAssignedException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyAssigned(UserAlreadyAssignedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(value = CandidateWrongPrecinctException.class)
    public ResponseEntity<ErrorResponse> handleCandidateWrongPrecinctException(CandidateWrongPrecinctException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(value = CodeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleCodeMismatchException(CodeMismatchException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(value = ElectionInvalidDateException.class)
    public ResponseEntity<ErrorResponse> handleElectionInvalidDateException(ElectionInvalidDateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}
