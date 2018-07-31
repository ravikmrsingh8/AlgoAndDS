package com.example.amazon.hashing;
import java.util.*;

/**
 * Input:
 * 1
 * 10
 * 2 1 1 6 8 2 4 3 3 4
 *
 * OUTPUT: 4
 */
public class ConsecutiveNums {
    static int findLongestConsecutiveSeq(int[] arr,int N){
        int len = 1;
        int maxLen = len;
        Set<Integer> set = new TreeSet<>();
        for(int e: arr)set.add(e);
        Iterator<Integer> itr = set.iterator();
        int prev = itr.next();
        while (itr.hasNext()){
            int curVal = itr.next();
            if(curVal-1 == prev){
                len++;
            } else  {
                if(len > maxLen){
                    maxLen = len;
                }
                len = 1;
            }
            prev = curVal;
        }
        System.out.println(set);
        return maxLen>len?maxLen:len;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = in.nextInt();
            sb.append(findLongestConsecutiveSeq(arr,N));
            sb.append("\n");
        }
        System.out.print(sb);
        in.close();
    }

}

