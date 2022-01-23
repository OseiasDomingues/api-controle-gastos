package com.API.ControleDeGastosMensais.services.exceptions;

public class FieldInvalidException extends RuntimeException {
    public FieldInvalidException(String message) {
        super(message);
    }
}
