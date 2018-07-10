package com.example.java.callback;


import java.util.Random;

public class Predict {
    public void predict(CallBack call){
        Random rand = new Random();
        if(rand.nextInt(2) != 0) {
            call.call();
        }
    }
}
