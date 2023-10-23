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
import java.util.UUID;

@Service
public class TransferMoneyService {

    private final TransferMoneyRepository transferMoneyRepository;

    public TransferMoneyService(TransferMoneyRepository transferMoneyRepository) {
        this.transferMoneyRepository = transferMoneyRepository;
    }

    public void transfer(TransferMoneyData transferMoneyData) {
        transferMoneyData.setId(String.valueOf(UUID.randomUUID()));
        Logger logger = new Logger("src/main/java/com/example/transfer_money_API/info/logs.txt");
        logger.log("Date | " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n"
                + "Card From | " + transferMoneyData.getCardFromNumber() + "\n"
                + "Card To | " + transferMoneyData.getCardToNumber() + "\n"
                + "Value | " + transferMoneyData.getAmount().getValue() + "\n"
                + "Commission | 1%" + "\n"
                + "ID | " + transferMoneyData.getId());
        transferMoneyRepository.saveTransferData(transferMoneyData);
    }

    public OperationStatus confirm(ConfirmationData confirmationData) throws ErrorInputData {
        TransferMoneyData transferMoneyData = transferMoneyRepository.getTransfers().pop();
        String code = transferMoneyRepository.getOperations()
                .getOrDefault(transferMoneyData.getId(), "0000");
        if (confirmationData.getCode().equals(code)) {
            return transferMoneyRepository.saveConfirmationData(confirmationData);
        } else {
            throw new ErrorInputData("Wrong verification code!");
        }
    }
}
