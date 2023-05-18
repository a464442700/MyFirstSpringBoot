package com.example.myfirstspringboot.controller;

import com.example.myfirstspringboot.model.Payment;
import com.example.myfirstspringboot.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }
    @PostMapping("/payments")
    public Payment createPayment(
            @RequestBody Payment payment
    ) { System.out.println("PaymentsController");
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}