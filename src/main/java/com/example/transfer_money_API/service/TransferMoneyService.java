package com.example.transfer_money_API.service;

import com.example.transfer_money_API.exception.ErrorInputData;
import com.example.transfer_money_API.exception.ErrorTransfer;
import com.example.transfer_money_API.model.OperationStatus;
import com.example.transfer_money_API.model.TransferMoneyData;
import com.example.transfer_money_API.repository.TransferMoneyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public Optional<OperationStatus> transfer(TransferMoneyData transferMoneyData) throws ErrorInputData, ErrorTransfer {
        transferMoneyRepository.saveTransferData(transferMoneyData);
        return Optional.of(new OperationStatus(String.valueOf(idCounter.incrementAndGet()), "Successful Operation"));
    }
}
