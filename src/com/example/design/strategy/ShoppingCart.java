package com.example.design.strategy;

public class ShoppingCart {
    private PaymentOption payOption;

    public ShoppingCart(PaymentOption payOption) {
        this.payOption = payOption;
    }

    public ShoppingCart() {
        this.payOption = new CashOnDelivery();
    }

    public PaymentOption getPayOption() {
        return payOption;
    }

    public void setPayOption(PaymentOption payOption) {
        this.payOption = payOption;
    }

    public void chekoutAndPay() {
        payOption.pay();
    }
}
