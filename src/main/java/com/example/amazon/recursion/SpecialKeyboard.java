package com.example.amazon.recursion;

/**
 * magine you have a special keyboard with the following keys:
 * Key 1:  Prints 'A' on screen
 * Key 2: (Ctrl-A): Select screen
 * Key 3: (Ctrl-C): Copy selection to buffer
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 *
 * If you can only press the keyboard for N times (with the above four keys),
 * what could be maximum numbers of A's printed
 *
 * Bellow solution works for max 100 Key press
 */
public class SpecialKeyboard {
    static int N = 100;
    static int[] maxChars= new int[N+1];
    static {
        for(int i=0;i<=6;i++) maxChars[i] = i;
        for(int i=7;i<=N;i++) {
            for(int n= i-3;n>0;n--){
                int val = maxChars[n] * (i-n-1);
                if( val> maxChars[i])maxChars[i] =val;
            }
        }
    }
    public static void main (String[] args) {
        System.out.println("A's "+maxChars[7]);
        System.out.println("A's "+maxChars[10]);
        System.out.println("A's "+maxChars[20]);
    }
}
