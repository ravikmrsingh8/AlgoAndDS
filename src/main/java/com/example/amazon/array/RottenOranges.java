package com.example.amazon.array;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int grid[][] = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {2, 0, 0, 2, 1}
        };

        System.out.println("Min Time :"+findMinTime(grid, 3, 5));

        grid = new int[][] {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        System.out.println("Min Time :"+findMinTime(grid, 3, 5));



    }

    static int findMinTime(int[][] grid, int R, int C) {
        Queue<Orange> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.offer(new Orange(i, j));
            }
        }

        int time = 0;
        q.offer(null);
        while (!q.isEmpty()) {
            Orange orange = q.poll();
            if (orange == null) {
                if(q.isEmpty()) break;
                q.offer(null);
                time++;
                continue;
            }

            for (int i = 0; i < x.length; i++) {
                int ni = orange.i + x[i];
                int nj = orange.j + y[i];

                if ((ni >= 0 && ni < R)
                        && (nj >= 0 && nj < C)
                        && (grid[ni][nj] == 1)) {
                    grid[ni][nj] = 2;
                    q.offer(new Orange(ni, nj));
                    fresh--;
                }
            }

        }
        return (fresh == 0) ? time : -1;
    }


    static int x[] = {1, 0, -1, 0};
    static int y[] = {0, 1, 0, -1};

    static class Orange {
        int i;
        int j;

        Orange(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
