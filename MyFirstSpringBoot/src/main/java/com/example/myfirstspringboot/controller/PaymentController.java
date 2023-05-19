package com.example.myfirstspringboot.controller;

import com.example.myfirstspringboot.model.Payment;
import com.example.myfirstspringboot.model.PaymentDetails;
import com.example.myfirstspringboot.service.ErrorDetails;
import com.example.myfirstspringboot.service.PaymentService;
import com.example.myfirstspringboot.util.NotEnoughMoneyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader(required = false)  String requestId,
            @RequestBody Payment payment
    ) {

        payment.setId(UUID.randomUUID().toString());
        payment.setStatus("支付成功");

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }

    @PostMapping("/paymenttest")
    public Payment createPaymenttest(
            @RequestHeader(required = false)  String requestId,
            @RequestBody Payment payment
    ) {

        payment.setId(UUID.randomUUID().toString());
        payment.setStatus("支付成功");

        return payment;
    }
//    @PostMapping("/payment")
//    public ResponseEntity<?> makePayment(
//            @RequestBody PaymentDetails obj
//
//    ) {
//        System.out.println(obj);
//        try {
//            PaymentDetails paymentDetails =
//                    paymentService.processPayment();
//            return ResponseEntity
//                    .status(HttpStatus.ACCEPTED)
//                    .body(paymentDetails);
//        } catch (NotEnoughMoneyException e) {
//            ErrorDetails errorDetails = new ErrorDetails();
//            errorDetails.setMessage("Not enough money to make the payment.");
//
//            return ResponseEntity
//                    .badRequest()
//                    .body(errorDetails);
//
//
//        }
//    }

}