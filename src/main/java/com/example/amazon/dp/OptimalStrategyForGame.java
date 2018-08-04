package com.example.amazon.dp;

import java.util.Arrays;
import java.util.function.Function;

/**
 * For a number N . Tom and Jerry will play the game alternatively
 * and each of them would subtract a number n [n< N] such that N%n=0.
 * The game is repeated turn by turn until the one, who now cannot make a further move looses the game.
 * The game begins with Tom playing first move.
 * It is well understood that both of them will make moves in optimal way.
 * You are to determine who wins the game.
 *
 * Eg for N = 4
 * Tom = 4-1 = 3
 * Jerry= 3-1 = 2
 * Tom 2-1 = 1
 * Jerry can't subtract anything(0 not allowed) so Tom wins
 *
 */
public class OptimalStrategyForGame {
    public static void main(String[] args) {
        int N = 9;
        evaluate(OptimalStrategyForGame::tomAndJerry, N);

        System.out.println("Dynamic Programming");
        evaluate(OptimalStrategyForGame::tomAndJerryDp, N);
    }

    static boolean tomAndJerry(int N) {
        recCalls++;
        if(N == 1) return false;
        if(N == 2) return true;


        for(int n = 1; n<=Math.sqrt(N) && N%n == 0; n++){
            // If there are any n such that
            // When tom subtract n and for N-n Jerry Don't have any solution
            // return true
            if(!tomAndJerry(N-n)) {
                return true;
            }
        }
        return false;

    }


    static int[] dp ;
    static {
        dp = new int[101];
        Arrays.fill(dp,-1);
    }
    static boolean tomAndJerryDp(int N) {
        recCalls++;
        if(N == 1) return false;
        if(N == 2) return true;

        if(dp[N] != -1) return dp[N] == 1;
        for(int n = 1; n<=Math.sqrt(N) && N%n == 0; n++){
            // If there are any n such that
            // When tom subtract n and for N-n Jerry Don't have any solution
            // return true
            dp[N-n] = 0;
            if(!tomAndJerry(N-n)) {
                dp[N-n] = 1;
                return true;
            }
        }

        dp[N] = 0;
        return false;
    }

    //Utility
    static int recCalls = 0;
    static void evaluate(Function<Integer, Boolean> func, int N){
        recCalls =0;
        long start = System.nanoTime();
        System.out.println(func.apply(N)?"Tom":"Jerry");
        long end = System.nanoTime();
        System.out.println("Recursive Calls "+recCalls);
        System.out.println("Total Time "+ (end-start)/Math.pow(10, 6)+ "ms");
        System.out.println(Arrays.toString(dp));
        System.out.println();
    }
}
