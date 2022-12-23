package com.camila.beneficiarios.controller;

import com.camila.beneficiarios.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler( MethodArgumentNotValidException.class )
    @ResponseStatus( HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors( MethodArgumentNotValidException exception ) {
        BindingResult bindResult =  exception.getBindingResult();
        List< String > messages = bindResult.getAllErrors().stream().map( objectError -> objectError.getDefaultMessage() )
                .collect( Collectors.toList() );

        return new ApiErrors( messages );
    }

    @ExceptionHandler( ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException( ResponseStatusException ex ) {
        String menssageError = ex.getReason();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors( menssageError );
        return new ResponseEntity( apiErrors, codigoStatus );
    }
}
