package org.evote.backend.users.account.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message) {
        super(message);
    }

}
