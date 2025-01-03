package com.dpv.entregable04.TransactionMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication
@SpringBootConfiguration
@EnableReactiveMongoAuditing
@EnableReactiveMongoRepositories(basePackages = "com.dpv.entregable04.TransactionMs.repositories")
public class TransactionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionMsApplication.class, args);
	}

}
