package com.personapi.personapi.config.model.constant;

public enum ResponseExceptionHandler {


    ERRO_VALIDATION_FIELDS("Error in field validation"),
    VALIDATION_ERROR("validation_error");

    private String textException;

    private ResponseExceptionHandler(String textException) {
        this.textException = textException;
    }

    public String getTextException() {
        return this.textException;
    }
}