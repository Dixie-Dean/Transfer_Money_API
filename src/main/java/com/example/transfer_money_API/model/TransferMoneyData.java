package com.example.transfer_money_API.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferMoneyData {
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private String cardToValidTill;
    private String cardToCVV;
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