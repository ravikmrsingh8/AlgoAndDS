package com.example.dp;

public class CoinChanger {
    int[] coins;
    int count = 0;
    public CoinChanger(int[] coins){
        this.coins = coins;
    }
    int numberOfWays(int N){
        return numberOfWays(this.coins.length, N);
    }

    int numberOfWays(int M, int N) {
        count++;
        if(M == 0 && N > 0) return 0;
        if(N == 0) return 1;
        if(N < 0) return 0;

        int a = numberOfWays(M-1, N);
        int b = numberOfWays(M,N - this.coins[M-1]);
        return  a+b;
    }

    public static void main(String[] args) {
        CoinChanger changer = new CoinChanger(new int[]{1,2,3,4,5,6});
        System.out.println(changer.numberOfWays(30));
        System.out.println("Recursive Calls :"+changer.count);

    }

}
