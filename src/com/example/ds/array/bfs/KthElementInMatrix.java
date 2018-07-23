package com.example.ds.array.bfs;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 *         10, 20, 30, 40
 *         15, 25, 35, 45
 *         24, 29, 37, 48
 *         32, 33, 39, 50
 *
 *         The 3rd smallest element is 20 and 7th smallest element is 30
 */
public class KthElementInMatrix {
    static boolean[][] visited;
    private static int getKthSmallest(int[][] a,int k, int N) {

        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(a[0][0], 0, 0));
        visited[0][0] = true;
        while(!q.isEmpty() && k > 0) {
            k--;
            Node  node = q.poll();

            if(k==0) return node.data;
            int i = node.i + 1;
            if(node.i + 1 < N && !visited[node.i+1][node.j]) {
                visited[node.i+1][node.j] = true;
                q.offer(new Node(a[node.i+1][node.j], node.i+1, node.j));
            }
            if(node.j + 1 < N &&  !visited[node.i][node.j + 1]) {
                visited[node.i][node.j+1] = true;
                q.offer(new Node(a[node.i][node.j + 1], node.i, node.j+1));
            }
        }
        throw new RuntimeException("Shouldn't Occur");
    }


    static class Node implements Comparable<Node> {
        int i;
        int j;
        int data;
        Node(int data, int i,int j){
            this.data = data;
            this.i = i;
            this.j = j;
        }
        public int compareTo(Node b){
            return this.data - b.data;
        }
    }


    public static void kthSmallest(int[][] a,int n,int k){
        //add code here.
        visited = new boolean[n][n];
        System.out.println(getKthSmallest(a, k, n));

    }

    public static void main(String[] args) {
        int[][] a = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };
        kthSmallest(a, 4, 3);
        kthSmallest(a, 4, 7);
    }
}
