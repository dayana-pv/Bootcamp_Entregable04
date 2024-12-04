package com.dpv.entregable04.AccountMs;

import com.dpv.entregable04.AccountMs.domain.Account;
import com.dpv.entregable04.AccountMs.domain.AccountType;
import com.dpv.entregable04.AccountMs.dto.AccountRequest;
import com.dpv.entregable04.AccountMs.repositories.AccountRepository;
import com.dpv.entregable04.AccountMs.services.impl.AccountServiceImpl;
import com.dpv.entregable04.AccountMs.utils.AccountNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTests {
	@Mock
	private AccountRepository accountRepository;
	@Mock
    private AccountNumberGenerator accountNumberGenerator;

	@InjectMocks
	private AccountServiceImpl accountService;

	private AccountRequest accountRequest;
	private Account account;

	@BeforeEach
	public void setUp() {
		accountRequest = AccountRequest.builder()
				.accountType(AccountType.AHORROS)
				.customerId(1L)
				.build();
		
		account = Account.builder()
				.id(1L)
				.accountNumber("10000000")
				.balance(100.00)
				.accountType(AccountType.AHORROS)
				.customerId(1L)
				.build();
	}

	/*
	@Test
	public void saveAccountTest() {
		// Precondition
		when(accountNumberGenerator.accountNumberGenerator()).thenReturn("10000000");

		Account otherAccount = Account.builder()
        				.id(1L)
        				.accountNumber("10000000")
        				.balance(100.00)
        				.accountType(accountRequest.getAccountType())
        				.customerId(accountRequest.getCustomerId())
        				.build();

		when(accountRepository.save(ArgumentMatchers.any(Account.class))).thenReturn(otherAccount);

		// Action
		Account savedAccount = accountService.saveAccount(accountRequest);

		// Verify
		assertThat(savedAccount).isNotNull();
		assertThat(savedAccount.getAccountNumber()).isEqualTo("10000000");
	}

	 */

	@Test
	public void listAccountsTest() {
		Account otherAccount = Account.builder()
				.id(1L)
				.accountNumber("20000000")
				.balance(300.00)
				.accountType(AccountType.AHORROS)
				.customerId(2L)
				.build();

		// Precondition
		when(accountRepository.findAll()).thenReturn(List.of(account, otherAccount));

		// Action
		List<Account> accountList = accountService.listAccounts();

		// Verify
		assertThat(accountList).isNotNull();
		assertThat(accountList.size()).isGreaterThan(1);
	}
}
