package com.example.transfer_money_API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
    @Positive(message = "The amount cannot be zero or negative")
    private int amount;

    @NotBlank(message = "Enter currency")
    private String currency;
}