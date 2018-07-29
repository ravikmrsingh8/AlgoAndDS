package com.example.dp;

public class MinimumInsertionForPalindrome {

    static int count = 0;
    public static void main(String[] args) {
        count = 0;
        System.out.println(insertions("geeksforgeeks"));
        System.out.println("Recursive Calls " + count);

        count =0;
        System.out.println(insertions("as"));
        System.out.println("Recursive Calls " + count);

        count =0;
        System.out.println(insertions("ass"));
        System.out.println("Recursive Calls " + count);

        count =0;
        System.out.println(insertions("aba"));
        System.out.println("Recursive Calls " + count);

    }

    static int insertions(String word) {
        //StringBuilder res = new StringBuilder(word);

        return insertions(word.toCharArray(), 0, word.length()-1);
    }

    static int insertions(char[] word, int start, int end){
        count++;
        if(end <= start) return 0;

        if(word[start] != word[end]) {

            int a = insertions(word, start+1, end);
            int b = insertions(word, start, end-1);

            return 1 + Math.min(a, b);
        } else {
            return insertions(word, start+1, end-1);
        }
    }
}
