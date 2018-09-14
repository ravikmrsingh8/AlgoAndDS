package gfg.mustdoques.array;

/**
 * Given an unsorted gfg.mustdoques.array of non-negative integers,
 * find a continuous sub-gfg.mustdoques.array which adds to a given number.
 * print -1 if no sub gfg.mustdoques.array exist with given sum
 * input
 * gfg.mustdoques.array 1 2 3 7 5 sum 12
 * output i= 2, j = 4
 */
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 7, 5};
        int sum = 12;
        Pair p =findSubArray(arr, sum);
        if(p == null) System.out.println(-1);
        else System.out.println((p.first +1) + " " +(p.second+1));
    }

    static class Pair {
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static Pair findSubArray(int[] arr, int sum){
        int i=0;
        int curSum = 0;
        for(int j=0;j<arr.length;j++){
            curSum += arr[j];
            while(curSum > sum) {
                curSum -= arr[i++];
            }
            if(curSum == sum) return new Pair(i,j);
        }
        return null;
    }
}
