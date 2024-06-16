package org.evote.backend.users.address.exceptions;

public class AddressInfoNotComplete extends RuntimeException{
    public AddressInfoNotComplete(String message) {
        super(message);
    }
}
