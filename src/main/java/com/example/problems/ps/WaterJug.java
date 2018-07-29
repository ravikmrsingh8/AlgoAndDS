package com.example.problems.ps;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaterJug {
    int C1 = 3;
    int C2 = 5;
    int G = 4;
    int tries = 0;

    WaterJug(int C1, int C2, int G) {
        this.C1 = C1;
        this.C2 = C2;
        this.G = G;
    }

    boolean[][] visited;

    boolean isSafe(State s) {
        int i = s.v1;
        int j = s.v2;
        return ((i >= 0 && i <= C1)
                && (j >= 0 && j <= C2)
                && !visited[i][j]);
    }


    List<State> getMoves(State state) {
        int V1 = state.v1;
        int V2 = state.v2;

        List<State> states = new ArrayList<>();

        //Empty First Jug
        states.add(new State(0, V2));
        //Empty Second Jug
        states.add(new State(V1, 0));


        //Fill First Jug
        states.add(new State(C1, V2));
        //Fill Second Jug
        states.add(new State(V1, C2));

        //Transfer to first Jug
        if (V1 + V2 > C1) {
            states.add(new State(C1, V2 + V1 - C1));
        } else {
            states.add(new State(V1 + V2, 0));
        }

        //Transfer to second jug
        if (V1 + V2 > C2) {
            states.add(new State(V1 + V2 - C2, C2));
        } else {
            states.add(new State(0, V1 + V2));
        }

        return states;
    }


    State  bfs(State s0) {
        s0.prev = null;
        Queue<State> q = new LinkedList<>();
        q.offer(s0);
        visited = new boolean[C1+1][C2+1];
        visited[s0.v1][s0.v2] = true;
        while(!q.isEmpty()) {
            tries++;
            State s = q.poll();
            if(s.v1 == G || s.v2 == G) return s;
            for (State state : getMoves(s)) {
                if(isSafe(state)) {
                    state.prev = s;
                    visited[state.v1][state.v2] = true;
                    q.offer(state);
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        //Capcaity1, Capacity2 , Goal
        WaterJug jug = new WaterJug(123, 125, 122);
        State goal = jug.bfs(new State(0,0));
        if(goal != null) {
            System.out.println("Goal achieved after " +jug.tries +" Trials");
            while(goal!= null) {
                System.out.println("["+ goal.v1 + ", "+goal.v2+"]");
                goal = goal.prev;
            }
        } else {
            System.out.println("Goal Can not be achieved");
        }


    }

    static class State {
        int v1;
        int v2;
        State prev;
        State(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}

