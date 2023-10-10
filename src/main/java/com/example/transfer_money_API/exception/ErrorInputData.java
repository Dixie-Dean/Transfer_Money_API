package com.example.transfer_money_API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ErrorInputData extends Exception {
    public ErrorInputData(String message) {
        super(message);
    }
}
