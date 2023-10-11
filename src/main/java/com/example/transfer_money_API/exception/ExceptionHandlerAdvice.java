package com.example.transfer_money_API.exception;

import com.example.transfer_money_API.model.OperationStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleErrorInputData(ErrorInputData e) {
        return new ResponseEntity<>(new OperationStatus(e.getId(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleErrorTransfer(ErrorTransfer e) {
        return new ResponseEntity<>(new OperationStatus(e.getId(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
