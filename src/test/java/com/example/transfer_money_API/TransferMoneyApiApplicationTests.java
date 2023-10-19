package com.example.transfer_money_API;

import com.example.transfer_money_API.controller.TransferMoneyController;
import com.example.transfer_money_API.dto.Amount;
import com.example.transfer_money_API.dto.ConfirmationData;
import com.example.transfer_money_API.dto.OperationStatus;
import com.example.transfer_money_API.dto.TransferMoneyData;
import com.example.transfer_money_API.exception.ErrorInputData;
import com.example.transfer_money_API.repository.TransferMoneyRepository;
import com.example.transfer_money_API.service.TransferMoneyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransferMoneyApiApplicationTests {

	@Test
	void transferServiceTest() {
		//given
		TransferMoneyService service = Mockito.mock(TransferMoneyService.class);
		Mockito.when(service.transfer(Mockito.any())).thenReturn(
				new OperationStatus("0", "Successful"));

		TransferMoneyController controller = new TransferMoneyController(service);

		//act
		controller.transfer(Mockito.any());

		//verify
		Mockito.verify(service, Mockito.atLeastOnce()).transfer(Mockito.any());
	}

	@Test
	void transferRepositoryTest() {
		//given
		Amount amount = Mockito.mock(Amount.class);
		Mockito.when(amount.getValue()).thenReturn(100);
		Mockito.when(amount.getCurrency()).thenReturn("RUR");

		TransferMoneyData transferMoneyData = Mockito.mock(TransferMoneyData.class);
		Mockito.when(transferMoneyData.getCardFromNumber()).thenReturn("1234");
		Mockito.when(transferMoneyData.getCardFromValidTill()).thenReturn("12/34");
		Mockito.when(transferMoneyData.getCardFromCVV()).thenReturn("123");
		Mockito.when(transferMoneyData.getCardToNumber()).thenReturn("5678");
		Mockito.when(transferMoneyData.getAmount()).thenReturn(amount);

		TransferMoneyRepository repository = Mockito.mock(TransferMoneyRepository.class);
		Mockito.when(repository.saveTransferData(transferMoneyData))
				.thenReturn(new OperationStatus("0", "Successful"));

		TransferMoneyService service = new TransferMoneyService(repository);
		TransferMoneyController controller = new TransferMoneyController(service);

		//act
		controller.transfer(transferMoneyData);

		//verify
		Mockito.verify(repository, Mockito.atLeastOnce()).saveTransferData(transferMoneyData);
	}

	@Test
	void confirmSuccessTest() throws ErrorInputData {
		//given
		ConfirmationData confirmationData = new ConfirmationData();
		confirmationData.setCode("0000");
		confirmationData.setOperationId(null);

		TransferMoneyRepository repository = Mockito.mock(TransferMoneyRepository.class);
		Mockito.when(repository.saveConfirmationData(confirmationData)).thenReturn(
				new OperationStatus("0", "Successful"));

		TransferMoneyService service = new TransferMoneyService(repository);
		TransferMoneyController controller = new TransferMoneyController(service);

		//act
		controller.confirmOperation(confirmationData);

		//verify
		Mockito.verify(repository, Mockito.atLeastOnce()).saveConfirmationData(confirmationData);
	}

	@Test
	void confirmErrorTest() {
		//given
		ConfirmationData confirmationData = new ConfirmationData();
		confirmationData.setCode("0001");
		confirmationData.setOperationId(null);

		TransferMoneyRepository repository = Mockito.mock(TransferMoneyRepository.class);
		Mockito.when(repository.saveConfirmationData(confirmationData)).thenReturn(
				new OperationStatus("0", "Successful"));

		TransferMoneyService service = new TransferMoneyService(repository);
		TransferMoneyController controller = new TransferMoneyController(service);

		//verify
		Assertions.assertThrows(ErrorInputData.class, () -> controller.confirmOperation(confirmationData));
	}

}
