package com.API.ControleDeGastosMensais.controllers.exceptions;

import com.API.ControleDeGastosMensais.services.exceptions.DatabaseException;
import com.API.ControleDeGastosMensais.services.exceptions.EntityNotFoundException;
import com.API.ControleDeGastosMensais.services.exceptions.FieldInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<StandardError> objNotFound(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String msgError = "Objeto não encontrado";
        StandardError err = new StandardError(Instant.now(), status.value(), msgError, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String msgError = "Error no banco de dados";
        StandardError err = new StandardError(Instant.now(), status.value(), msgError, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(FieldInvalidException.class)
    ResponseEntity<StandardError> fieldInvalid(FieldInvalidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String msgError = "Campo Invalido!";
        StandardError err = new StandardError(Instant.now(), status.value(), msgError, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
