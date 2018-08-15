package com.example.backtracking;

import java.util.*;


public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        List<Character> path = ratInMaze(maze);
        if(path.isEmpty()){
            System.out.println("No solution exist to reach end");
        }
        System.out.println(path);
        printMaze(maze);
    }


    static LinkedList<Character> ratInMaze(int[][] maze){
        LinkedList<Character> path = new LinkedList<>();
        ratInMaze(maze,maze.length, maze[0].length,0,0, path);
        return path;
    }


    static char[] moves = {'D','L','R','U'};
    static Map<Character, Move> map = new HashMap<>();
    static {
        map.put('D', new Move(1,0));
        map.put('L', new Move(0,-1));
        map.put('R', new Move(0,1));
        map.put('U', new Move(-1,0));
    }

    static boolean isSafe(int[][] maze, int R, int C, int i, int j){
        return (i>=0 && i<R) && (j>=0 && j<C) && (maze[i][j] == 1);
    }
    private static boolean ratInMaze(int[][] maze, int R, int C, int i, int j, LinkedList<Character> path) {
        if(i== R-1 && j== C-1)return true;

        maze[i][j] = 2;

        for(char move : moves){
            int ni = i+ map.get(move).di;
            int nj = j+ map.get(move).dj;
            if(isSafe(maze, R, C, ni, nj)){
                maze[ni][nj] = 2;
                path.add(move);
                if(ratInMaze(maze,R,C, ni,nj, path)){
                    return  true;
                }
                path.pollLast();
                maze[ni][nj] = 1;
            }
        }
        maze[i][j] = 1;
        return false;
    }

    static void printMaze(int[][] maze){
        for(int[] m: maze){
            System.out.println(Arrays.toString(m));
        }
    }
    static class Move{
        int di;
        int dj;

        public Move(int di, int dj) {
            this.di = di;
            this.dj = dj;
        }
    }
}
