package com.example.bit;

public enum Base {
    _2( 2,"01"),
    _10(10,"0123456789"),
    _16(16,"0123456789ABCDEF"),
    _62(62,"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

    Base(int radix, String alphabet){
        this.alphabet = alphabet;
        this.radix = radix;
    }

    private String alphabet;
    private int radix;

    public int getRadix() {
        return radix;
    }

    public String getAlphabet() {
        return alphabet;
    }


}
