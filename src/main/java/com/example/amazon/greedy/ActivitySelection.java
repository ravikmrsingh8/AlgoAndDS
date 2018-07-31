package com.example.amazon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class ActivitySelection {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while(T-->0) {
            int N = in.nextInt();
            int start[] = new int[N];
            int[] end = new int[N];
            for(int i=0;i<N;i++)start[i] = in.nextInt();
            for(int i=0;i<N;i++)end[i] = in.nextInt();
            Activity[] a = new Activity[N];

            for(int i=0;i<N;i++){
                a[i] = new Activity(start[i], end[i]);
            }

            Arrays.sort(a, Comparator.comparingInt(a1 -> a1.end));
            System.out.println(Arrays.toString(a));
            Stack<Activity> stack = new Stack<Activity>();
            stack.push(a[0]);
            for(int i=1;i<N;i++){
                if(a[i].start >= stack.peek().end){
                    stack.push(a[i]);
                }
            }
            System.out.println(stack.size());

        }

        in.close();
    }

    static class Activity{
        int start;
        int end;
        Activity(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "["+start+","+end +"]";
        }
    }
}
