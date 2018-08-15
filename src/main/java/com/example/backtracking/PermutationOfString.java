package com.example.backtracking;


public class PermutationOfString {
    public static void main(String[] args) {
        //List<String> perm = permute("ABC");
        //System.out.println(perm);
        permute("", "ABC");
    }

    static void permute(String prefix, String suffix){

    }

    static String swap(String str,int i,int j){
        if(i == j) return str;
        char[] s = str.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return new String(s);
    }
}
