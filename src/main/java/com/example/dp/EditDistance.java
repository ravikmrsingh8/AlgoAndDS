package com.example.dp;

import java.util.function.BiFunction;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert str1 into str2.
 * <p>
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * <p>
 * Examples:
 * <p>
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 * <p>
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 * <p>
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println("Recursive Solution");
        evaluate(EditDistance::editDistance, "geek", "gesek");
        evaluate(EditDistance::editDistance, "sunday", "saturday");
        evaluate(EditDistance::editDistance, "google", "goggle");

        System.out.println("DP Solution");
        evaluate(EditDistance::editDistanceDp, "geek", "gesek");
        evaluate(EditDistance::editDistanceDp, "sunday", "saturday");
        evaluate(EditDistance::editDistanceDp, "google", "goggle");

    }

    static int editDistance(String s1, String s2) {
        return editsRec(s1, s1.length(), s2, s2.length());
    }

    static int editsRec(String str1, int M, String str2, int N) {

        recCalls++;
        if (M == 0 || N == 0) {
            return Math.abs(M - N);
        }

        if (str1.charAt(M - 1) == str2.charAt(N - 1)) {
            return editsRec(str1, M - 1, str2, N - 1);
        }

        //Insert
        int e1 = 1 + editsRec(str1, M, str2, N - 1);
        //delete
        int e2 = 1 + editsRec(str1, M - 1, str2, N);
        //update
        int e3 = 1 + editsRec(str1, M - 1, str2, N - 1);
        return Math.min(e1, Math.min(e2, e3));
    }


    static int recCalls = 0;

    static void evaluate(BiFunction<String, String, Integer> func, String s1, String s2) {
        recCalls = 0;
        long s = System.nanoTime();
        int result = func.apply(s1, s2);
        long e = System.nanoTime();

        System.out.println("Edit Distance :" + result);
        System.out.println("Recursive Calls:" + recCalls);
        System.out.println("Time Taken : " + (e - s) / Math.pow(10, 6) + " ms\n");
    }


    // Dp Solution
    static int editDistanceDp(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) dp[i][0] = i;
        for (int j = 0; j <= N; j++) dp[0][j] = j;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[M][N];
    }
}
