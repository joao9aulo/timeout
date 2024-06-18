package com.example.timeout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {

    @Autowired
    private RestTemplate restTemplate;


    public String callSlowService() {
        return this.restTemplate.getForObject("http://localhost:8081/slow", String.class);
    }
}
