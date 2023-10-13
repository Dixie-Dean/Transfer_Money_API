package com.example.transfer_money_API.exception;

import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.logger.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    private final Logger logger = new Logger("src/main/java/com/example/transfer_money_API/info/logs.txt");

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String id = String.valueOf(UUID.randomUUID());

        StringBuilder description = new StringBuilder();
        for (FieldError fieldError : e.getFieldErrors()) {
            description.append(fieldError.getDefaultMessage()).append(" ");
        }

        logger.log("Date | " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n"
                + "Status | " + description + "\n");

        return new ResponseEntity<>(new OperationStatus(id, description.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleErrorInputData(ErrorInputData e) {

        logger.log("Date | " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n"
                + "Status | " + e.getMessage() + "\n");

        return new ResponseEntity<>(new OperationStatus(
                String.valueOf(UUID.randomUUID()), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OperationStatus> handleErrorTransfer(ErrorTransfer e) {

        logger.log("Date | " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n"
                + "Status | " + e.getMessage() + "\n");

        return new ResponseEntity<>(new OperationStatus(
                String.valueOf(UUID.randomUUID()), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}