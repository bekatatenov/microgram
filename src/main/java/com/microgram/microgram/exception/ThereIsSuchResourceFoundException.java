package com.microgram.microgram.exception;

public class ThereIsSuchResourceFoundException extends RuntimeException {
    public ThereIsSuchResourceFoundException() {
        super();
    }

    public ThereIsSuchResourceFoundException(String message) {
        super(message);
    }

    public ThereIsSuchResourceFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThereIsSuchResourceFoundException(Throwable cause) {
        super(cause);
    }

    protected ThereIsSuchResourceFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
