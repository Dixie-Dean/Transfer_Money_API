package com.example.transfer_money_API.service;

import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import com.example.transfer_money_API.repository.TransferMoneyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;
    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public Optional<OperationStatus> transfer(TransferMoneyData transferMoneyData) {
        transferMoneyRepository.saveTransferData(transferMoneyData);

        return Optional.of(new OperationStatus(String.valueOf(UUID.randomUUID()), "Successful Operation"));
    }
}
