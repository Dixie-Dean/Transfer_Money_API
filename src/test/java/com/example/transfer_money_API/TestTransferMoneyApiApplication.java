package com.example.transfer_money_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTransferMoneyApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(TransferMoneyApiApplication::main).with(TestTransferMoneyApiApplication.class).run(args);
	}

}
