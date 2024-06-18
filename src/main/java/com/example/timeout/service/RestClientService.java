package com.example.timeout.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestClientService {

    private final WebClient webClient;

    public RestClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public String callSlowService() {
        return this.webClient.get()
                .uri("/slow")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
