package com.personapi.personapi.exception;

public class PersonException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public PersonException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public PersonException(String msg) {
    }
}