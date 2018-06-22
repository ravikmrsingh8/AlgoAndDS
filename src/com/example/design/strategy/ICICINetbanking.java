package com.example.design.strategy;

public class ICICINetbanking implements PaymentOption {
    @Override
    public void pay() {
        System.out.println("Payment from ICICI NetBanking");
    }
}
