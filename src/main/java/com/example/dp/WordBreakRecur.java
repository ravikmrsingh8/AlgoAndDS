package com.example.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 *   cream, icecream, man, go, mango}
 *
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 *
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung"
 * or "i like sam sung".
 */
public class WordBreakRecur {
    static Set<String> dictionary = new HashSet<>(Arrays.asList(
            "i", "like", "sam", "sung", "samsung", "mobile", "ice",
             "cream", "icecream", "man", "go", "mango", "and"
    ));

    public static void main(String[] args) {
        System.out.println(wordBreak("ilikeicecreamandice"));
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
