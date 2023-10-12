package com.example.transfer_money_API.repository;

import com.example.transfer_money_API.dto.ConfirmationData;
import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Repository
public class TransferMoneyRepository {
    private final List<TransferMoneyData> transfers = new ArrayList<>();
    private final List<ConfirmationData> confirmations = new ArrayList<>();

    public OperationStatus saveTransferData(TransferMoneyData transferMoneyData) {
        transfers.add(transferMoneyData);
        return new OperationStatus(String.valueOf(UUID.randomUUID()), "Successful Operation!");
    }

    public OperationStatus saveConfirmationData(ConfirmationData confirmationData) {
        confirmations.add(confirmationData);
        return new OperationStatus(String.valueOf(UUID.randomUUID()), "Operation Confirmed!");
    }
}
