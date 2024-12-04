package com.dpv.entregable04.TransactionMs.repositories;

import com.dpv.entregable04.TransactionMs.domain.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
