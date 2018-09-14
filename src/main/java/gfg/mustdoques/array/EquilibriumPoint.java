package gfg.mustdoques.array;

import java.util.function.Function;

public class EquilibriumPoint {
    public static void main(String[] args) {
        evaluate(EquilibriumPoint::findEquilibriumPoint, new int[]{1, 3, 5, 2, 2});
        evaluate(EquilibriumPoint::findEquilibriumPoint, new int[]{1});
    }

    static int findEquilibriumPoint(int[] arr){
        int N = arr.length;
        int[] l = new int[N];
        int[] r = new int[N];
        l[0] = 0;
        r[N-1] = 0;
        for(int i=1; i<N; i++)l[i] = l[i-1] + arr[i-1];
        for(int j=N-2; j>=0; j--) r[j] = r[j+1]+ arr[j+1];
        for(int i=0;i<N;i++){
            if(l[i] == r[i]) return i+1;
        }
        return -1;
    }

    static void evaluate(Function<int[], Integer> func, int[] arr){
        long time = System.nanoTime();
        int point = func.apply(arr);
        System.out.println("Eq Point: " + point );
        System.out.println("Time " + (System.nanoTime()-time)/1000000.0 + " ms");
    }
}
