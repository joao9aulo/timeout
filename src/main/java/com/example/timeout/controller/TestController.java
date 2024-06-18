package com.example.timeout.controller;

import com.example.timeout.service.RestClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final RestClientService restClientService;

    public TestController(RestClientService restClientService) {
        this.restClientService = restClientService;
    }

    @GetMapping("/test-timeout")
    public ResponseEntity<String> testTimeout() {
        try {
            String response = restClientService.callSlowService();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timed out");
        }
    }
}
