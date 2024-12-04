package com.dpv.entregable04.AccountMs.services;

import com.dpv.entregable04.AccountMs.domain.Account;
import com.dpv.entregable04.AccountMs.dto.AccountRequest;

import java.util.List;

public interface AccountService {
    Account saveAccount(AccountRequest accountRequest);
    List<Account> listAccounts();
    Account getAccountById(Long id);
    List<Account> getAccountsByCustomerId(Long customerId);
    boolean deleteAccount(Long id);
}
