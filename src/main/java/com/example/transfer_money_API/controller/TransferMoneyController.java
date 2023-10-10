package com.example.transfer_money_API.controller;

import com.example.transfer_money_API.model.TransferMoneyData;
import com.example.transfer_money_API.service.TransferMoneyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferMoneyController {

    private final TransferMoneyService transferMoneyService;

    public TransferMoneyController(TransferMoneyService transferMoneyService) {
        this.transferMoneyService = transferMoneyService;
    }

    @PostMapping("/transfer")
    public TransferMoneyData transfer(@RequestBody TransferMoneyData transferMoneyData) {
        System.out.println(transferMoneyData);
        return transferMoneyData;
    }

}
