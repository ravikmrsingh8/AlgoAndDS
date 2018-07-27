package com.example.problems.ps;

import java.util.LinkedList;
import java.util.Queue;
public class IslandsUsingBFS {
    boolean[][] visited;
    int N;
    int M;
    int[][] arr;

    boolean isSafe(int i, int j) {
        return ((i>=0 && i < N)
                && (j>=0 && j < M)
                && (!visited[i][j])
                && (arr[i][j] == 1));
    }

    int movei[] = {1, 1, 0, -1, -1, -1, 0, 1};
    int movej[] = {0, 1, 1, 1, 0, -1, -1, -1};

    void bfs(int i, int j) {

        Node n0 = new Node(i, j);
        Queue<Node> q = new LinkedList<>();
        q.offer(n0);
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int m = 0; m < movei.length; m++) {
                int ni = node.i + movei[m];
                int nj = node.j + movej[m];
                if (isSafe(ni, nj)) {
                    visited[ni][nj] = true;
                    q.offer(new Node(ni, nj));
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] plot = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        IslandsUsingBFS islands = new IslandsUsingBFS();
        System.out.print("IslandsUsingBFS :");
        System.out.println(islands.findIslands(plot, plot.length,plot[0].length));
    }
    public  int findIslands(int[][] a, int n, int m) {
        //Add your code here.
        visited = new boolean[n][m];
        N = n;
        M = m;
        int islands = 0;
        arr = a;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0 && !visited[i][j]) {
                    islands++;
                    bfs(i, j);
                }
            }
        }
        return islands;
    }

    static class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
