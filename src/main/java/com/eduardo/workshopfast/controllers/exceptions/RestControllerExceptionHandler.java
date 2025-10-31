package com.eduardo.workshopfast.controllers.exceptions;

import com.eduardo.workshopfast.exceptions.ResourceAlreadyExistsException;
import com.eduardo.workshopfast.exceptions.ResourceNotFoundException;
import com.eduardo.workshopfast.controllers.exceptions.data.ErrorMessage;
import com.eduardo.workshopfast.controllers.exceptions.data.FieldMessage;
import com.eduardo.workshopfast.controllers.exceptions.data.ValidationErrorData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorData handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {

        List<FieldMessage> errors = new ArrayList<>();
        for(FieldError f : e.getBindingResult().getFieldErrors()){
            errors.add(new FieldMessage(f.getField(), f.getDefaultMessage()));
        }

        return new ValidationErrorData(HttpStatus.BAD_REQUEST.value(), errors);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleResourceAlreadyExists(ResourceAlreadyExistsException e, HttpServletRequest request) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
