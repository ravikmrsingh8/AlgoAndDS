package com.example.problems.misc;

public class HourAndMinuteHandAngle {
    public static void main(String[] args) {
        System.out.println("Angle (6:30):\t"+ angle(6, 30));
        System.out.println("Angle (9:40):\t"+ angle(9, 40));
        System.out.println("Angle (5:10):\t"+ angle(5, 10));
        System.out.println("Angle (11:45):\t"+ angle(11, 45));
    }

    static double angle(int h, int m) {
        h = h % 12;
        m = m % 60;
        double hAngle = (h * 60 + m) * 0.5;
        double mAngle = m * 6;
        double angle = Math.abs(mAngle - hAngle);
        angle = angle > 180? 360 - angle:angle;
        return angle;
    }
}
