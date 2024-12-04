package com.dpv.entregable04.AccountMs.services.impl;

import com.dpv.entregable04.AccountMs.domain.Account;
import com.dpv.entregable04.AccountMs.dto.AccountRequest;
import com.dpv.entregable04.AccountMs.repositories.AccountRepository;
import com.dpv.entregable04.AccountMs.services.AccountService;
import com.dpv.entregable04.AccountMs.utils.AccountNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountNumberGenerator accountNumberGenerator = AccountNumberGenerator.getInstance();

    @Override
    public Account saveAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .accountNumber(accountNumberGenerator.accountNumberGenerator())
                .balance(0.0)
                .accountType(accountRequest.getAccountType())
                .customerId(accountRequest.getCustomerId())
                .build();

        accountRepository.save(account);

        return account;
    }

    @Override
    public List<Account> listAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("La cuenta no existe"));
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepository
                .findByCustomerId(customerId);
    }

    @Override
    public boolean deleteAccount(Long id) {
        accountRepository.deleteById(id);
        return true;
    }
}
