package com.aws.compass.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    @GetMapping("/api/ad/payment")
    public ResponseEntity<?> getPayments() {
        return ResponseEntity.ok(null);
    }
}
