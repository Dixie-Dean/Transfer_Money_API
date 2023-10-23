package com.example.transfer_money_API.repository;

import com.example.transfer_money_API.dto.ConfirmationData;
import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Repository
public class TransferMoneyRepository {
    private final Map<String, String> operations = new ConcurrentHashMap<>();
    private final Deque<TransferMoneyData> transfers = new ConcurrentLinkedDeque<>();
    private final List<ConfirmationData> confirmations = new CopyOnWriteArrayList<>();

    public void saveTransferData(TransferMoneyData transferMoneyData) {
        operations.put(transferMoneyData.getId(), "0000");
        transfers.push(transferMoneyData);
    }

    public OperationStatus saveConfirmationData(ConfirmationData confirmationData) {
        confirmations.add(confirmationData);
        return new OperationStatus(String.valueOf(UUID.randomUUID()), "Operation Confirmed!");
    }
}
