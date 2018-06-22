package com.example.design.strategy;

public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.chekoutAndPay();

        cart.setPayOption(new Paytm());
        cart.chekoutAndPay();

        cart.setPayOption(new ICICINetbanking());
        cart.chekoutAndPay();
    }
}
