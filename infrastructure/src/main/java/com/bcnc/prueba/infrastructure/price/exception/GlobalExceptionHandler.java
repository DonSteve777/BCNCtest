package com.bcnc.prueba.infrastructure.price.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // devuelve un json en el body con el mensaje de la excepción
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(PriceNotFoundException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }
}
