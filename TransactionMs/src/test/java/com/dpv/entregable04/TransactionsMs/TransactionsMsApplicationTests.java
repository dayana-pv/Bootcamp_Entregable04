package com.dpv.entregable04.TransactionsMs;

import com.dpv.entregable04.TransactionMs.TransactionMsApplication;
import com.dpv.entregable04.TransactionMs.domain.Transaction;
import com.dpv.entregable04.TransactionMs.domain.TransactionType;
import com.dpv.entregable04.TransactionMs.dto.TransactionRequest;
import com.dpv.entregable04.TransactionMs.repositories.TransactionRepository;
import com.dpv.entregable04.TransactionMs.services.impl.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TransactionMsApplication.class)
class TransactionsMsApplicationTests {

	@Mock
	private TransactionRepository transactionRepository;

	@InjectMocks
	private TransactionServiceImpl transactionService;

	private TransactionRequest transactionRequest;
	private Transaction transaction;

	@BeforeEach
	public void setUp() {

		transaction = transaction.builder()
				.transactionType(TransactionType.DEPOSITO)
				.amount(100.00)
				.date(LocalDateTime.now())
				.originAccount("345345")
				.build();
	}
	/*
	@Test
	public void listCustomersTest() {
		Transaction otherTransaction = Transaction.builder()
				.transactionType(TransactionType.DEPOSITO)
				.amount(100.00)
				.date(LocalDateTime.now())
				.originAccount("12345678")
				.build();

		// Precondition
		when(transactionRepository.findAll()).thenReturn(List.of(transaction, otherTransaction));

		// Action
		List<Transaction> transactionList = transactionService.listTransactions();

		// Verify
		assertThat(transactionList).isNotNull();
		assertThat(transactionList.size()).isGreaterThan(1);
	}

	 */


}
