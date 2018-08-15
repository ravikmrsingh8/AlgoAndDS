package com.example.amazon.dp;

import java.util.Arrays;

/**
 *
 * In share trading, a buyer buys shares and sells on future date.
 * Given stock price of n days, the trader is allowed to make at most k transactions,
 * where new transaction can only start after previous transaction is complete,
 * find out maximum profit that a share trader could have made.
 *
 * Input:
 * Price = [10, 22, 5, 75, 65, 80]
 *     K = 2
 * Output:  87 (Buy at price 10, sell at 22, buy at 5 and sell at 80)
 *Price = [12, 14, 17, 10, 14, 13, 12, 15]
 * K = 3
 * Output:  12
 *
 * Algorithm
 * let profit(T, D) = maximum profit obtained by doing at most T txn up to Day D
 * then profit(T, D) = maximum of ( profit(T, D-1) AND  maximum of (price[D]- price[d] + profit(T-1, d))
 * where d goes from D-1 to 1
 *
 */
public class ProfitBySellingSharesAtMostKTimes {
    public static void main(String[] args) {

        int K = 2;
        int[] price = new int[]{10, 22, 5, 75, 65, 80};
        int profit = maximumProfit(price, price.length, K);
        System.out.println(profit);

        price = new int[]{12, 14, 17, 10, 14, 13, 12, 15};
        K = 3;
        profit = maximumProfit(price, price.length, K);
        System.out.println(profit);

        profit = maximumProfitDP(price,price.length,K);
        System.out.println(profit);
    }

    static int maximumProfit(int[] price, int D, int K){
        if(K == 0) return 0;
        if(D == 0) return 0;

        int profit1 = maximumProfit(price, D-1, K);
        int profit2 = Integer.MIN_VALUE;
        for(int d=0;d<D-1;d++){
            profit2 = Math.max(profit2, price[D-1]-price[d] + maximumProfit(price, d,K-1));
        }
        return Math.max(profit1, profit2);
    }

    //DP Solution
    static int[][] dp;
    static {
        dp = new int[10][100];
        for(int[] d : dp)Arrays.fill(d, -1);
    }
    static int maximumProfitDP(int[] price, int D, int K){
        if(K== 0) return 0;
        if(D== 0) return 0;
        if(dp[K][D] != -1) return dp[K][D];
        int profit1 = maximumProfitDP(price, D-1, K);
        int profit2 = Integer.MIN_VALUE;
        for(int d=0;d<D-1;d++){
            profit2 = Math.max(profit2, price[D-1] - price[d] + maximumProfitDP(price,d,K-1));
        }
        dp[K][D] = Math.max(profit2, profit1);
        return dp[K][D];
    }
}
