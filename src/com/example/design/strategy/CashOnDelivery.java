package com.example.design.strategy;

public class CashOnDelivery implements PaymentOption {
    @Override
    public void pay() {
        System.out.println("Cash On delivery");
    }
}
