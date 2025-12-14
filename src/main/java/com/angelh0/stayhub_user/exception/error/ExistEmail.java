package com.angelh0.stayhub_user.exception.error;

public class ExistEmail extends RuntimeException {
    public ExistEmail(String message) {
        super(message);
    }
}
