package com.example.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakDP {
    static boolean[] wb ;
    static Set<String> dictionary = new HashSet<>(Arrays.asList(
            "i", "like", "sam", "sung", "samsung", "mobile", "ice",
            "cream", "icecream", "man", "go", "mango", "and"
    ));

    public static void main(String[] args) {
        String str = "ilikeicecreamandice";
        wb = new boolean[str.length()];
        /// TODO: 17-07-2018  
        // System.out.println(wordBreak(str, 0));
    }

    static boolean wordBreak(String word) {
        if(word.isEmpty()) return true;
        for(int i=0;i<word.length();i++) {
            if(dictionary.contains(word.substring(0,i+1))) {
                if(wordBreak(word.substring(i+1))) return true;
            }
        }
        return false;
    }
}
