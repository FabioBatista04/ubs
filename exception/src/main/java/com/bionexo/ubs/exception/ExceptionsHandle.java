package com.bionexo.ubs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionsHandle {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    private ExceptionResponse missingServletRequestParameterException(HttpServletRequest request) {
        return ExceptionResponse.builder()
                .timestamp(System.currentTimeMillis())
                .status(BAD_REQUEST.value())
                .error("Dados inválidos")
                .message("Deve ser informado latitude e longitude para pesquisa")
                .path(request.getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalParameterException.class)
    private ExceptionResponse missingServletRequestParameterException(IllegalParameterException e, HttpServletRequest request) {
        return ExceptionResponse.builder()
                .timestamp(System.currentTimeMillis())
                .status(BAD_REQUEST.value())
                .error("Dados inválidos")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
    }
}
