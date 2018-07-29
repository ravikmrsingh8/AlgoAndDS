package com.example.design.strategy;

public class Paytm implements PaymentOption {
    @Override
    public void pay() {
        System.out.println("Paying through paytm");
    }
}
