package com.example.transfer_money_API.service;

import com.example.transfer_money_API.dto.ConfirmationData;
import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import com.example.transfer_money_API.exception.ErrorInputData;
import com.example.transfer_money_API.logger.Logger;
import com.example.transfer_money_API.repository.TransferMoneyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;

    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public OperationStatus transfer(TransferMoneyData transferMoneyData) {
        Logger logger = new Logger("src/main/java/com/example/transfer_money_API/info/logs.txt");
        OperationStatus operationStatus = transferMoneyRepository.saveTransferData(transferMoneyData);
        logger.log("Date | " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n"
                + "Card From | " + transferMoneyData.getCardFromNumber() + "\n"
                + "Card To | " + transferMoneyData.getCardToNumber() + "\n"
                + "Sum | " + transferMoneyData.getAmount().getSum() + "\n"
                + "Commission | 1%" + "\n"
                + "Status | " + operationStatus.getDescription() + "\n");
        return operationStatus;
    }

    public OperationStatus confirm(ConfirmationData confirmationData) throws ErrorInputData {
        if (confirmationData.getVerificationCode().equals("0000")) {
            return transferMoneyRepository.saveConfirmationData(confirmationData);
        } else {
            throw new ErrorInputData("Wrong verification code!");
        }
    }
}
