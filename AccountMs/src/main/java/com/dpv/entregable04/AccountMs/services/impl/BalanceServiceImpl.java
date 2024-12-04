package com.dpv.entregable04.AccountMs.services.impl;

import com.dpv.entregable04.AccountMs.domain.Account;
import com.dpv.entregable04.AccountMs.repositories.AccountRepository;
import com.dpv.entregable04.AccountMs.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BalanceServiceImpl implements BalanceService {
    private final AccountRepository accountRepository;

    @Override
    public Account depositBalance(Long id, Double amount){
        Optional<Account> account = accountRepository.findById(id);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() + amount;
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public Account depositBalanceAccount(String accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() + amount;
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public Account removeBalance(Long id, Double amount) {
        Optional<Account> account = accountRepository.findById(id);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() - amount;

        if (newBalance < 0) {
            throw new RuntimeException("No tiene suficiente saldo para realizar el retiro.");
        }

        // Si pasa las verificaciones, actualizar el saldo
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

    @Override
    public Account removeBalanceAccount(String accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        if(account.isEmpty()) {
            throw new RuntimeException("La cuenta no existe");
        }

        Double newBalance = account.get().getBalance() - amount;

        if (newBalance < 0) {
            throw new RuntimeException("No tiene suficiente saldo para realizar el retiro.");
        }

        // Si pasa las verificaciones, actualizar el saldo
        account.get().setBalance(newBalance);

        accountRepository.save(account.get());

        return account.get();
    }

}
