package com.dpv.entregable04.TransactionMs.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AccountWebClientImpl implements AccountWebClient {
    private final WebClient webClient;

    public AccountWebClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090/api/accounts").build();
    }

    public Mono<Account> depositBalanceAccount(String account, Double amount) {
        return webClient
                .put()
                .uri("/{account}/depositAccount", account)
                .bodyValue(amount)
                .retrieve()
                .bodyToMono(Account.class);
    }

    public Mono<Account> removeBalanceAccount(String account, Double amount) {
        return webClient
                .put()
                .uri("/{account}/removeAccount", account)
                .bodyValue(amount)
                .retrieve()
                .bodyToMono(Account.class);
    }
}
