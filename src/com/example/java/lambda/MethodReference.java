package com.example.java.lambda;

public class MethodReference {
    public static void main(String[] args) {
        doPerform(MethodReference::play, "Laila...");
    }

    static void play(String song){
        System.out.println("Playing "+song);
    }
    static void doPerform(Player player, String song){
        player.play(song);
    }
}
