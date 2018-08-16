package com.example.ds.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Rearrange characters in a string such that no two adjacent are same
 * Given a string with repeated characters,
 * task is rearrange characters in a string so that no two adjacent characters are same.
 *
 * Note : It may be assumed that the string has only lowercase English alphabets.
 */
public class RearrangeCharacters {
    public static void main(String[] args) {

        System.out.println(reArrange("aaabc"));
        System.out.println(reArrange("aaab"));
    }
    static String reArrange(String str){
        Queue<Node> q = new PriorityQueue<>((n1,n2)->n2.f -n1.f);
        int[] freq = new int[26];
        for(char ch: str.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i] !=0){
                q.offer(new Node((char)('a'+i), freq[i]));
            }
        }

        StringBuilder result = new StringBuilder();
        Node prev = new Node('$', 0);
        while(!q.isEmpty()){
            Node cur = q.poll();
            result.append(cur.ch);
            cur.f -= 1;
            if(prev.f > 0)q.offer(prev);
            prev = cur;
        }
        if(result.length() == str.length()) return result.toString();
        return "NOT POSSIBLE";
    }

    static class Node {
        char ch;
        int f;
        Node(char ch, int f) {
            this.ch = ch;
            this.f = f;
        }
    }
}
