package com.dpv.entregable04.AccountMs.services;

import com.dpv.entregable04.AccountMs.domain.Account;

public interface BalanceService {
    Account depositBalance(Long id, Double amount);
    Account depositBalanceAccount(String accountNumber, Double amount);
    Account removeBalance(Long id, Double amount);
    Account removeBalanceAccount(String accountNumber, Double amount);
}

