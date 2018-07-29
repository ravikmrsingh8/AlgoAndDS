package com.example.problems.ps;

public class FindMinDistBetweenTwoString {
    public static void main(String[] args) {
        String[] words = {"Hey", "How", "Are", "You", "Hello", "Hi", "You", "How"};

        System.out.println(findDistance(words, "How", "You"));
    }

    static int findDistance(String[] words, String wordA, String wordB) {
        int iA = -1;
        int iB = -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++) {
            if(words[i].equals(wordA))iA = i;
            if(words[i].equals(wordB))iB = i;
            if(iA != -1 && iB != -1) {
                dist = Math.min(dist, Math.abs(iA-iB));
            }
        }
        return dist;
    }
}
