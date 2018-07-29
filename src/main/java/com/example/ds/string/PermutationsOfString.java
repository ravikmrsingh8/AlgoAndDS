package com.example.ds.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsOfString {
    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(findAllPermutations(str));
    }

    private static List<String> findAllPermutations(String str) {
        LinkedList<String> permutations = new LinkedList<>();
        char[] letters = str.toCharArray();
        int N = str.length();
        permutations.add(""+letters[0]);

        for(int i=1; i<N; i++) {
            List<String> words = new ArrayList<>(permutations);
            for(String word : words) {
                for(int j=0;j<=word.length();j++) {
                    permutations.add(word.substring(0,j) + letters[i] + word.substring(j));
                }
                permutations.pollFirst();
            }
        }
        return permutations;
    }
}
