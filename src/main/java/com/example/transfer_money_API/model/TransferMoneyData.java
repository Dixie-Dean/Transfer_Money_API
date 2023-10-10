package com.example.transfer_money_API.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferMoneyData {
    @NotBlank
    @Size(min = 4, max = 4)
    private String cardFromNumber;
    @NotBlank
    @Size(min = 10, max = 10)
    private String cardFromValidTill;
    @NotBlank
    @Size(min = 3, max = 3)
    private String cardFromCVV;
    @NotBlank
    @Size(min = 4, max = 4)
    private String cardToNumber;
    @NotBlank
    @Size(min = 10, max = 10)
    private String cardToValidTill;
    @NotBlank
    @Size(min = 3, max = 3)
    private String cardToCVV;
    @NotNull
    private Amount amount;

    @Override
    public String toString() {
        return "Schema{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", cardToValidTill='" + cardToValidTill + '\'' +
                ", cardToCVV='" + cardToCVV + '\'' +
                ", amount=" + amount +
                '}';
    }
}