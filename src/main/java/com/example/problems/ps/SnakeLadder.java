package com.example.problems.ps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {
    int[] moves;
    boolean[] visited;

    public SnakeLadder() {
        moves = new int[100];
        Arrays.fill(moves, -1);
        addSnakes();
        addLadders();
    }

    public void addSnakes() {
        moves[16] = 6;
        moves[53] = 33;
        moves[61] = 17;
        moves[63] = 59;
        moves[86] = 23;
        moves[92] = 72;
        moves[94] = 74;
        moves[98] = 77;
    }

    public void addLadders() {
        moves[3] = 10;
        moves[8] = 30;
        moves[19] = 37;
        moves[39] = 58;
        moves[62] = 80;
        moves[70] = 90;
    }

    class Cell {
        int index;
        int dist;
        Cell prev;

        Cell(int index, int dist) {
            this.index = index;
            this.dist = dist;
            prev = null;
        }
    }


    public int minMoveToLast() {
        visited = new boolean[100];
        Cell c = new Cell(0, 0);
        Queue<Cell> q = new LinkedList<>();
        q.offer(c);

        while (!q.isEmpty()) {
            c = q.poll();
            if (c.index == 99) break;
            if (moves[c.index] != -1) {
                c.index = moves[c.index];
            }
            for (int i = 1; i <= 6; i++) {
                Cell v = new Cell(c.index + i, c.dist + 1);
                v.prev = c;
                q.offer(v);

            }
        }

        int answer  = c.dist;
        while(c.prev != null) {
            System.out.print(c.index+ " ");
            c = c.prev;
        }
        System.out.println();
        return answer;
    }

    public static void main(String[] args) {
        SnakeLadder game = new SnakeLadder();
        System.out.print("Minimum Move to reach last cell: " + game.minMoveToLast());
    }
}
