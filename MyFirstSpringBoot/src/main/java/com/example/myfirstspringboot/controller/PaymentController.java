package com.example.myfirstspringboot.controller;

import com.example.myfirstspringboot.model.PaymentDetails;
import com.example.myfirstspringboot.service.ErrorDetails;
import com.example.myfirstspringboot.service.PaymentService;
import com.example.myfirstspringboot.util.NotEnoughMoneyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails =
                    paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");

            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);


        }
    }
}