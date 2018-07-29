package com.example.java.callback;

public class CallBackDemo {

    public static void main(String[] args) {
        Predict predict = new Predict();

        System.out.println("Asking If i should Run");
        predict.predict(new CallBack() {
            @Override
            public void call() {
                System.out.println("Run, Run back to India");;
            }
        });
    }
}
