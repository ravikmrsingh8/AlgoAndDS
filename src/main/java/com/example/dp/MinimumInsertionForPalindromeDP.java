package com.example.dp;

import java.util.Arrays;

public class MinimumInsertionForPalindromeDP {

    static int count = 0;
    static int palindrome[][];
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(insertions("geeksforgeeks"));
        System.out.println(insertions("geeks"));
        System.out.println(insertions("as"));
        System.out.println(insertions("ass"));
        System.out.println(insertions("aba"));
    }

    static int insertions(String word) {
        palindrome = new int[word.length()][word.length()];
        for (int[] ps : palindrome) {
            Arrays.fill(ps, INF);
        }
        return insertions(word.toCharArray(), 0, word.length() - 1);
    }

    static int insertions(char[] word, int start, int end) {

        if (end <= start) return 0;
        if (palindrome[start][end] != INF) {
            return palindrome[start][end];
        }
        if (word[start] != word[end]) {
            palindrome[start + 1][end] = insertions(word, start + 1, end);
            palindrome[start][end - 1] = insertions(word, start, end - 1);
            return 1 + Math.min(palindrome[start + 1][end], palindrome[start][end - 1]);
        } else {
            palindrome[start + 1][end - 1] = insertions(word, start + 1, end - 1);
            return palindrome[start + 1][end - 1];
        }
    }
}
