package com.example.ds.string;


import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        List<String> list = permutations("0123456789");
        System.out.println("All Permutations :"+list.size());
        System.out.println((System.currentTimeMillis()-t1)+"ms");
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    static List<String> permutations(String str){
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(""));
        for(int i=0; i<str.length(); i++){
            list = permutations(list,str.charAt(i));
        }
        return list;
    }
    static List<String> permutations(List<String> list, char ch) {
        List<List<String>> listOfList = new ArrayList<>();
        List<String> perms = new ArrayList<>();
        for(String str : list) {
            listOfList.add(permutations(str, ch));
        }
        for(List<String> list1 : listOfList) {
            perms.addAll(list1);
        }
        return perms;
     }
    static List<String> permutations(String str, char ch) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<=str.length() ;i++) {
            String permute = str.substring(0,i)+ ch+ str.substring(i,str.length());
            list.add(permute);
        }
        return list;
    }
}
