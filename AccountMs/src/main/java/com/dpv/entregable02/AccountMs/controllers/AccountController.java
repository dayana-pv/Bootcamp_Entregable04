package com.dpv.entregable02.AccountMs.controllers;

import com.dpv.entregable02.AccountMs.domain.Account;
import com.dpv.entregable02.AccountMs.dto.AccountRequest;
import com.dpv.entregable02.AccountMs.dto.BalanceRequest;
import com.dpv.entregable02.AccountMs.services.AccountService;
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

    @PutMapping("/{id}/deposit")
    public Account depositBalance(@PathVariable Long id, @RequestBody @Valid @NotNull Double amount) {
        return accountService.depositBalance(id, amount);
    }

    @PutMapping("/{account}/depositAccount")
    public Account depositBalanceAccount(@PathVariable String account, @RequestBody @Valid @NotNull Double amount) {
        return accountService.depositBalanceAccount(account, amount);
    }

    @PutMapping("/{id}/remove")
    public Account removeBalance(@PathVariable Long id, @RequestBody @Valid @NotNull Double amount) {
        return accountService.removeBalance(id, amount);
    }

    @PutMapping("/{account}/removeAccount")
    public Account removeBalanceAccount(@PathVariable String account, @RequestBody @Valid @NotNull Double amount) {
        return accountService.removeBalanceAccount(account, amount);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }
}
