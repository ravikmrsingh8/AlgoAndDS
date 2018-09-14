package gfg.mustdoques.array;

import java.util.Arrays;
import java.util.function.Consumer;

public class Sort012 {
    public static void main(String[] args) {
        evaluate(Sort012::sort012, new int[]{0,0,0});
        evaluate(Sort012::sort012, new int[]{1,1,1});
        evaluate(Sort012::sort012, new int[]{2,2,2});
        evaluate(Sort012::sort012, new int[]{0,1,2});
        evaluate(Sort012::sort012, new int[]{2,1,0});

        evaluate(Sort012::sort012, new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
        evaluate(Sort012::sort012, new int[]{2, 2, 1, 1, 1,  1,  0, 0, 0, 0});
        evaluate(Sort012::sort012, new int[]{1, 1, 1, 1, 1,  1,  0, 0, 0, 0});
        evaluate(Sort012::sort012, new int[]{0, 2, 2, 2, 0,  2,  0,1, 0, 0, 0});
    }

    static void sort012(int[] arr){
        int N = arr.length;
        int _0end = -1;
        int _2start = N;
        int i = 0;
        while(i < _2start) {
            if(arr[i] == 0 ) {
                _0end += 1;
                swap(_0end,i++,arr);
            } else if( arr[i] == 2) {
                _2start -= 1;
                swap(_2start, i, arr);
            } else {
                i++;
            }
        }
    }

    static void swap(int i, int j, int[] arr) {
        int e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }

    static void evaluate(Consumer<int[]> func, int[] arr){
        long time = System.nanoTime();
        func.accept(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Time " + (System.nanoTime()-time)/1000000.0 + " ms");
    }
}
