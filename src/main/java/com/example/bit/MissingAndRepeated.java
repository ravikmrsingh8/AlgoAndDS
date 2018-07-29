package com.example.bit;

import javafx.util.Pair;

public class MissingAndRepeated {
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    public static void main(String[] args) {
        System.out.println(NEGATIVE_INFINITY);
        System.out.println(NEGATIVE_INFINITY + 1);

        System.out.println(NEGATIVE_INFINITY + 1 == NEGATIVE_INFINITY);
    }


}
