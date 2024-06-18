package com.example.slowservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowServiceController {

    @GetMapping("/slow")
    public ResponseEntity<String> slowEndpoint() throws InterruptedException {
        // Simula um atraso de 10 segundos
        Thread.sleep(10000);
        return ResponseEntity.ok("Response after delay");
    }
}