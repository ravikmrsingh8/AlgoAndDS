package com.example.dp;

public class MinimumStepToOne {
    static int dp[] = new int[100];

    static void init() {
        dp[1] = 0;
        dp[2] = dp[3] = 1;
        for (int i = 4; i < 100; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i % 3 == 0) dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println("Min Step for 89:" + findMinStep(89));
        System.out.println("Min Step for 7:" + findMinStep(7));
        System.out.println("Min Step for 21:" + findMinStep(21));
        System.out.println("Min Step for 8:" + findMinStep(8));
        System.out.println("Min Step for 4:" + findMinStep(4));
        System.out.println("Min Step for 10:" + findMinStep(10));
        System.out.println("Min Step for 9:" + findMinStep(9));
    }

    static int findMinStep(int N) {
        return dp[N];
    }
}
