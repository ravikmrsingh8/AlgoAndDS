package com.example.misc.app;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerApp {
    public static void main(String[] args) {
        TimerTask task = new TimerTask(){
            public void run() {
                System.out.print("\r");
                System.out.print(new Date());

            }
        };

        Timer timer = new Timer();
        timer.schedule(task,new Date(),1000);
    }

}
