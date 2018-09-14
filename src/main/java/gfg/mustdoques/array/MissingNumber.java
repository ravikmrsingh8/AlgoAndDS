package gfg.mustdoques.array;

/**
 * You are given a gfg.mustdoques.list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in gfg.mustdoques.list.
 * One of the integers is missing in the gfg.mustdoques.list. Write an efficient code to find the missing integer.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,6};
        int res = findMissingNumber(arr, 6);
        System.out.println(res);
    }

    static int findMissingNumber(int[] arr, int  N){
        int res = 0;
        //get xor of 1 to N
        for(int i=1;i<=N;i++)res ^=i;

        //xor res to all gfg.mustdoques.array elements
        for(int i=0;i<N-1;i++)res ^= arr[i];

        return res;
    }
}
