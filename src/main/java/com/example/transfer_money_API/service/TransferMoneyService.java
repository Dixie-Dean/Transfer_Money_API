package com.example.transfer_money_API.service;

import com.example.transfer_money_API.repository.TransferMoneyRepository;
import com.example.transfer_money_API.model.TransferMoneyData;
import org.springframework.stereotype.Service;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;

    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public TransferMoneyData save (TransferMoneyData transferMoneyData) {
        return transferMoneyRepository.save(transferMoneyData);
    }
}
