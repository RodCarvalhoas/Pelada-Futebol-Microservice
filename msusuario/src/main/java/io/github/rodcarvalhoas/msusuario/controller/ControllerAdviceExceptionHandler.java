package io.github.rodcarvalhoas.msusuario.controller;

import io.github.rodcarvalhoas.msusuario.exceptions.ErrorMessage;
import io.github.rodcarvalhoas.msusuario.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdviceExceptionHandler {

    //Metodo p/ sempre que for lançado o ResourceNotFoundException ele cair nesse metodo
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleRegraNegocioException(ResourceNotFoundException ex, WebRequest webRequest){
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                webRequest.getDescription(false));
    }

    //Captura as validações do Bean Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodNotValidException(MethodArgumentNotValidException ex, WebRequest webRequest){
        return  new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                webRequest.getDescription(false));
    }


}
