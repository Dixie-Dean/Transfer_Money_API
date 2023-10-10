package com.example.transfer_money_API.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class OperationStatus {
    private String id;
    private String description;

    public OperationStatus(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
