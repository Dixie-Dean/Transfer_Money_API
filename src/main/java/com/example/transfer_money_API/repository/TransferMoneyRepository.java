package com.example.transfer_money_API.repository;

import com.example.transfer_money_API.model.TransferMoneyData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransferMoneyRepository {
    private final List<TransferMoneyData> buffer = new ArrayList<>();

    public TransferMoneyData save(TransferMoneyData transferMoneyData) {
        buffer.add(transferMoneyData);
        return transferMoneyData;
    }
}
