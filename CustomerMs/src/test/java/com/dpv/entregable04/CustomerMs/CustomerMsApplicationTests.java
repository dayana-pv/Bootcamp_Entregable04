package com.dpv.entregable04.CustomerMs;

import com.dpv.entregable04.CustomerMs.domain.Customer;
import com.dpv.entregable04.CustomerMs.dto.CustomerRequest;
import com.dpv.entregable04.CustomerMs.repositories.CustomerRepository;
import com.dpv.entregable04.CustomerMs.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerMsApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerServiceImpl customerService;

	private CustomerRequest customerRequest;
	private Customer customer;

	@BeforeEach
	public void setUp() {
		customerRequest = CustomerRequest.builder()
				.name("Lucia")
				.lastName("Perez")
				.dni("23456789")
				.email("plucia@gmail.com")
				.build();

		customer = Customer.builder()
				.name("Juana")
				.lastName("Gonzales")
				.dni("54623822")
				.email("gjuana@gmail.com")
				.build();
	}
	@Test
	public void listCustomersTest() {
		Customer otherCustomer = Customer.builder()
				.name("Maria")
				.lastName("Lopez")
				.dni("12345678")
				.email("lmaria@gmail.com")
				.build();

		// Precondition
		when(customerRepository.findAll()).thenReturn(List.of(customer, otherCustomer));

		// Action
		List<Customer> customerList = customerService.listCustomers();

		// Verify
		assertThat(customerList).isNotNull();
		assertThat(customerList.size()).isGreaterThan(1);
	}

}







