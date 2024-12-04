package com.dpv.entregable04.AccountMs.repositories;

import com.dpv.entregable04.AccountMs.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByCustomerId(Long customerId);
    Optional<Account> findByAccountNumber(String accountNumber);
}
