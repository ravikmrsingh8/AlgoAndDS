package com.example.amazon.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AllPermutations {
    public static void main(String[] args) {
        evaluate(AllPermutations::permutations, "ABCDEFGHIJ");
        System.out.println("Permutations for ABCD\n" + permutations("ABCD"));
    }

    static List<String> permutations(String str){
        if(str.isEmpty()) return new ArrayList<>(Arrays.asList(""));

        List<String> perm = permutations(str.substring(1));
        List<String> newPerm = new ArrayList<>();
        char ch = str.charAt(0);
        perm.forEach(per->{
            for(int i=0;i<=per.length();i++){
                newPerm.add(per.substring(0,i)+ch+per.substring(i));
            }
        });
        return newPerm;
    }

    static void evaluate(Function<String,List<String>> func, String str){
        long start = System.nanoTime();
        List<String> perm = func.apply(str);
        long end = System.nanoTime();
        System.out.println("Time taken to generate Permutations for "+str +" :" + (end-start)/Math.pow(10,6)+" ms.");
    }

}
