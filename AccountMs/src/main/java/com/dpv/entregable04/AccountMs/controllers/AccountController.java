package com.dpv.entregable04.AccountMs.controllers;

import com.dpv.entregable04.AccountMs.domain.Account;
import com.dpv.entregable04.AccountMs.dto.AccountRequest;
import com.dpv.entregable04.AccountMs.dto.BalanceRequest;
import com.dpv.entregable04.AccountMs.services.AccountService;
import com.dpv.entregable04.AccountMs.services.BalanceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final BalanceService balanceService;

    @PostMapping()
    public Account registerAccount(@RequestBody @Valid AccountRequest accountRequest) {
        return accountService.saveAccount(accountRequest);
    }

    @GetMapping()
    public List<Account> listAccounts() {
        return accountService.listAccounts();
    }

    @GetMapping("/id/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getAccountsByCustomerId(@PathVariable Long customerId) {
        return accountService.getAccountsByCustomerId(customerId);
    }

    @PutMapping("/deposit/{id}")
    public Account depositBalance(@PathVariable Long id, @RequestBody @Valid BalanceRequest balanceRequest) {
        return balanceService.depositBalance(id, balanceRequest.getBalance());
    }

    @PutMapping("/{account}/depositAccount")
    public Account depositBalanceAccount(@PathVariable String account, @RequestBody @Valid BalanceRequest balanceRequest) {
        return balanceService.depositBalanceAccount(account, balanceRequest.getBalance());
    }

    @PutMapping("/remove/{id}")
    public Account removeBalance(@PathVariable Long id, @RequestBody @Valid BalanceRequest balanceRequest) {
        return balanceService.removeBalance(id, balanceRequest.getBalance());
    }

    @PutMapping("/{account}/removeAccount")
    public Account removeBalanceAccount(@PathVariable String account, @RequestBody @Valid BalanceRequest balanceRequest) {
        return balanceService.removeBalanceAccount(account, balanceRequest.getBalance());
    }

    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }
}
