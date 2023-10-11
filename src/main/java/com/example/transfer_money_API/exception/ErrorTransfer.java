package com.example.transfer_money_API.exception;

import lombok.Getter;

@Getter
public class ErrorTransfer extends Exception {
    public ErrorTransfer(String message) {
        super(message);
    }
}
