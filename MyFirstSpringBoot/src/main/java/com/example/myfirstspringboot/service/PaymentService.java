package com.example.myfirstspringboot.service;

import com.example.myfirstspringboot.model.PaymentDetails;
import com.example.myfirstspringboot.util.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}