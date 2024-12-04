package com.dpv.entregable04.CustomerMs.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dpv.entregable04.CustomerMs.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Optional<Customer> findByDni(String dni);
}