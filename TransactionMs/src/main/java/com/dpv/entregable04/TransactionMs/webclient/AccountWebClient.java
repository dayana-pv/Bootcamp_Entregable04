package com.dpv.entregable04.TransactionMs.webclient;

import reactor.core.publisher.Mono;

public interface AccountWebClient {
    Mono<Account> depositBalanceAccount(String account, Double amount);
    Mono<Account> removeBalanceAccount(String account, Double amount);
}
