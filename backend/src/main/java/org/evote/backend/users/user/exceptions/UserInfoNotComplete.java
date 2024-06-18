package org.evote.backend.users.user.exceptions;

public class UserInfoNotComplete extends RuntimeException {
    public UserInfoNotComplete(String message) {
        super(message);
    }
}
