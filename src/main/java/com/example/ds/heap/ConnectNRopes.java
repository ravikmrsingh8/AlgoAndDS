package com.example.ds.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * n ropes of different lengths are given, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths.
 * We need to connect the ropes with minimum cost.
 * For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
 * 1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 */
public class ConnectNRopes {
    public static void main(String[] args) {
        int[] ropes = {2, 4, 3, 6};
        System.out.println(getMinCost(ropes));
    }

    static int getMinCost(int[] ropes) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int rope : ropes) q.offer(rope);
        int cost = 0;
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            int c = a + b;
            cost += c;
            q.offer(c);
        }
        return cost;
    }
}
