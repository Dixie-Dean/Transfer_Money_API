package com.example.transfer_money_API.exception;

import lombok.Getter;

@Getter
public class ErrorInputData extends Exception {
    private final String id;
    private final String message;

    public ErrorInputData(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
