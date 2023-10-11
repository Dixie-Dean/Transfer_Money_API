package com.example.transfer_money_API.exception;

import com.example.transfer_money_API.dto.OperationStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new OperationStatus(
                String.valueOf(UUID.randomUUID()), "Error Input Data"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleErrorTransfer(ErrorTransfer e) {
        return new ResponseEntity<>(new OperationStatus(
                String.valueOf(UUID.randomUUID()), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}