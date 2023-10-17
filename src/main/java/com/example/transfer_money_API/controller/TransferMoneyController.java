package com.example.transfer_money_API.controller;

import com.example.transfer_money_API.dto.ConfirmationData;
import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import com.example.transfer_money_API.exception.ErrorInputData;
import com.example.transfer_money_API.service.TransferMoneyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://serp-ya.github.io/")
@RestController
public class TransferMoneyController {
    private final TransferMoneyService transferMoneyService;

    public TransferMoneyController(TransferMoneyService transferMoneyService) {
        this.transferMoneyService = transferMoneyService;
    }

    @PostMapping("/transfer")
    public OperationStatus transfer(@RequestBody TransferMoneyData transferMoneyData) {
        return transferMoneyService.transfer(transferMoneyData);
    }

    @PostMapping("/confirmOperation")
    public OperationStatus confirmOperation(@RequestBody ConfirmationData confirmationData) throws ErrorInputData {
        return transferMoneyService.confirm(confirmationData);
    }
}
