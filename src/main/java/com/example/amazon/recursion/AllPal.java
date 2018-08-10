package com.example.amazon.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AllPal {

    public static void main(String[] args) {
        String str = "xyzzyprxrpabxzxbxz";
        //String str = "aaaaaaa";
        evaluate(AllPal::palCountRec, str);
        evaluate(AllPal::palCountDP,str);
    }


    //Recursive Solution
    static int palCountRec(String str){
        recCalls++;
        if(str.length()== 0) return 0;
        if(str.length() == 1) return 0;

        int minCount = str.length()-1;

        for(int i=1 ;i<= str.length();i++){
            String prefix = str.substring(0,i);
            String rem = str.substring(i);
            if(isPal(prefix)){
                int count = !rem.isEmpty()? 1 + palCountRec(rem) : palCountRec(rem);
                if(count<minCount)minCount=count;
            }
        }
        return minCount;
    }

    static  boolean isPal(String str){
        int l = 0;
        int h = str.length()-1;
        while(l<h){
            if(str.charAt(l) != str.charAt(h)) return false;
            l++;h--;
        }
        return true;
    }

    // DP Solution
    static Map<String, Integer> map = new HashMap<>();
    static int palCountDP(String str){
        recCalls++;
        if(str.length()== 0) return 0;
        if(str.length() == 1) return 0;

        if(map.containsKey(str)) return map.get(str);
        int minCount = str.length()-1;

        for(int i=1 ;i<= str.length();i++){
            String prefix = str.substring(0,i);
            String rem = str.substring(i);
            if(isPal(prefix)){
                int count = !rem.isEmpty()? 1 + palCountDP(rem) : palCountDP(rem);
                if(count<minCount)minCount=count;
            }
        }
        map.put(str, minCount);
        return minCount;
    }



    //Evaluator
    static int recCalls = 0;
    static void evaluate(Function<String, Integer> func, String str){
        map.clear();
        recCalls = 0;
        long s = System.nanoTime();
        int N = func.apply(str);
        long e = System.nanoTime();

        System.out.println("Min partition "+ N);
        System.out.println("Rec Calls "+ recCalls);
        System.out.println("Total Time  :"+ (e-s)/Math.pow(10, 6)+" ms");
        System.out.println(map);
    }
}
