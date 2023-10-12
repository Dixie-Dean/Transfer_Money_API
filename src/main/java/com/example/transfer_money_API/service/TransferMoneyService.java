package com.example.transfer_money_API.service;

import com.example.transfer_money_API.dto.ConfirmationData;
import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import com.example.transfer_money_API.exception.ErrorInputData;
import com.example.transfer_money_API.repository.TransferMoneyRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;
    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public OperationStatus transfer(TransferMoneyData transferMoneyData) {
        return transferMoneyRepository.saveTransferData(transferMoneyData);
    }

    public OperationStatus confirm(ConfirmationData confirmationData) throws ErrorInputData {
        if (confirmationData.getVerificationCode().equals("0000")) {
            return transferMoneyRepository.saveConfirmationData(confirmationData);
        } else {
            throw new ErrorInputData("Wrong verification code!");
        }
    }
}
