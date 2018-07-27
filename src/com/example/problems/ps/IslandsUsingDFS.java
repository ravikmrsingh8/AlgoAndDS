package com.example.problems.ps;

public class IslandsUsingDFS {boolean[][] visited;
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

    void dfs(int i, int j) {
        visited[i][j] = true;
        for(int m =0; m < movei.length; m++){
            int ni = i+ movei[m];
            int nj = j+ movej[m];
            if(isSafe(ni, nj)) {
                dfs(ni, nj);
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
        IslandsUsingDFS islands = new IslandsUsingDFS();
        System.out.print("IslandsUsingDFS :");
        System.out.println(islands.findIslands(plot, plot.length,plot[0].length));
    }

    public int findIslands(int[][] a, int n, int m) {

        visited = new boolean[n][m];
        N = n;
        M = m;
        int islands = 0;
        arr = a;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0 && !visited[i][j]) {
                    islands++;
                    dfs(i, j);
                }
            }
        }
        return islands;
    }
}
