package com.example.transfer_money_API.repository;

import com.example.transfer_money_API.dto.TransferMoneyData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransferMoneyRepository {
    private final List<TransferMoneyData> buffer = new ArrayList<>();

    public void saveTransferData(TransferMoneyData transferMoneyData) {
        buffer.add(transferMoneyData);
    }

    public List<TransferMoneyData> getAllTransfers() {
        return buffer;
    }
}
