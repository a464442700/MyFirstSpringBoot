package com.example.myfirstspringboot.model;

public class PaymentDetails {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "amount=" + amount +
                '}';
    }
}
