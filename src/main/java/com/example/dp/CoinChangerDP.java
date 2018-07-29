package com.example.dp;

import java.util.Arrays;

public class CoinChangerDP {
    int[] coins;
    int change;
    int[][] dp;
    int count =0;
    public CoinChangerDP(int[] coins, int change){
        this.coins = coins;
        this.change = change;
    }

    public void setCoins(int[] coins) {
        this.coins = coins;
    }

    public void setChange(int change) {
        this.change = change;
    }

    int numberOfWays(){
        dp = new int[coins.length+1][change+1];
        for(int[] d : dp)Arrays.fill(d, -1);
        return numberOfWays(coins.length, change);
    }

    int numberOfWays(int M, int N) {
        count++;
        if(M == 0 && N >0) return 0;
        if(N == 0) return 1;
        if(N < 0) return 0;
        if(dp[M][N] != -1) return dp[M][N];


        dp[M-1][N] = numberOfWays(M-1, N);
        int b = numberOfWays(M, N- coins[M-1]);
        if(N- coins[M-1] >=0 ) dp[M][N- coins[M-1]] = b;
        return dp[M-1][N] + b;

    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CoinChangerDP dp = new CoinChangerDP(new int[]{1,2,3,4,5,6}, 30);
        System.out.println(dp.numberOfWays());
        System.out.println("Recursive Calls:" + dp.getCount());
    }
}
