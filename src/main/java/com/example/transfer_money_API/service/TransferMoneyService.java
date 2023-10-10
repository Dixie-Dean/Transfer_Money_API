package com.example.transfer_money_API.service;

import com.example.transfer_money_API.exception.ErrorInputData;
import com.example.transfer_money_API.model.OperationStatus;
import com.example.transfer_money_API.repository.TransferMoneyRepository;
import com.example.transfer_money_API.model.TransferMoneyData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public OperationStatus transfer(TransferMoneyData transferMoneyData) {
        transferMoneyRepository.saveTransferData(transferMoneyData);
        return new OperationStatus(String.valueOf(idCounter.incrementAndGet()), "Successful Operation");
    }
}
