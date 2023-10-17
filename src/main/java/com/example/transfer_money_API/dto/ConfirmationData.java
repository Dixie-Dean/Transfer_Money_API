package com.example.transfer_money_API.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfirmationData {
    private String operationId;
    private String code;

    @Override
    public String toString() {
        return "ConfirmationData{" +
                "operationId='" + operationId + '\'' +
                ", verificationCode='" + code + '\'' +
                '}';
    }
}
