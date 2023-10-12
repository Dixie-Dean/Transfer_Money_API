package com.example.transfer_money_API.exception;

import com.example.transfer_money_API.dto.OperationStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String id = String.valueOf(UUID.randomUUID());

        StringBuilder description = new StringBuilder();
        for (FieldError fieldError : e.getFieldErrors()) {
            description.append(fieldError.getDefaultMessage()).append(" ");
        }

        return new ResponseEntity<>(new OperationStatus(id, description.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleErrorTransfer(ErrorTransfer e) {
        return new ResponseEntity<>(new OperationStatus(
                String.valueOf(UUID.randomUUID()), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}