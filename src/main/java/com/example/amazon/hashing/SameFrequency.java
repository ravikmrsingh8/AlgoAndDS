package com.example.amazon.hashing;

import java.util.*;

/***
 * Given a string s which contains lower alphabetic characters,
 * the task is to check if its possible to  remove at most one character from this string
 * in such a way that frequency of each distinct character becomes same in the string
 *
 * T: 3
 * INPUT: dadada
 * OUTPUT: 1
 * INPUT: asdfasdfasdfg
 * OUTPUT: 1
 * INPUT: hhjjkkllmmm
 * OUTPUT: 1
 * INPUT: asdsafasdasfd
 * OUTPUT: 0
 */
public class SameFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0) {
            char[] str = in.next().toCharArray();
            System.out.println(possible(str) ? "1" : 0);
        }

        in.close();
    }

    static boolean possible(char[] str) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : str) charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        Map<Integer, Integer> freqMap = new HashMap<>();
        charMap.forEach((k, v) -> {
            freqMap.put(v, freqMap.getOrDefault(v, 0) + 1);
        });

        if (freqMap.size() > 2) return false;
        if (freqMap.size() == 1) return true;


        List<Pair> pairs = new ArrayList<>();
        freqMap.forEach((k, v) -> {
            pairs.add(new Pair(k, v));
        });

        int f1 = pairs.get(0).f;
        int f2 = pairs.get(1).f;
        int c1 = pairs.get(0).c;
        int c2 = pairs.get(1).c;
        if ((c1 == 1 && f1 == 1) || (c2 == 1 && f2 == 1)) return true;

        int N = charMap.size();
        if (c1 != N - 1 && c2 != N - 1) return false;
        if (Math.abs(f1 - f2) != 1) return false;
        return true;

    }

    static class Pair {
        int c;
        int f;

        Pair(int f, int c) {
            this.c = c;
            this.f = f;
        }
    }
}
