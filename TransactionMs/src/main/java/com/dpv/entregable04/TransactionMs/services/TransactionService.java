package com.dpv.entregable04.TransactionMs.services;

import com.dpv.entregable04.TransactionMs.domain.Transaction;
import com.dpv.entregable04.TransactionMs.dto.TransactionRequest;
import com.dpv.entregable04.TransactionMs.dto.TransferRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<Transaction> registerDeposit(TransactionRequest transactionRequest);
    Mono<Transaction> registerWithdrawal(TransactionRequest transactionRequest);
    Mono<Transaction> registerTransfer(TransferRequest transferRequest);
    Flux<Transaction> listTransactions();
}
