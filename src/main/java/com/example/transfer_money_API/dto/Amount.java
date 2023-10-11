package com.example.transfer_money_API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
    @Positive
    @NotBlank
    private int value;
    @NotEmpty
    private String currency;
}