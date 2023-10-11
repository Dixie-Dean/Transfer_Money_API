package com.example.transfer_money_API.exception;

import lombok.Getter;

@Getter
public class ErrorTransfer extends Exception {
    private final String id;
    private final String message;

    public ErrorTransfer(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
