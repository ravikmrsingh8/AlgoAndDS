package com.example.ds.string;

public class ReverseWords {
    public static void main(String[] args) {
        String str = "blue is sky";
        String revWord = reverseWords(str);
        System.out.println(revWord);
    }
    static String reverseWords(String str){
        char strArr[] = str.toCharArray();
        reverse(strArr, 0, str.length()-1);
        boolean wordOut = true;
        boolean wordIn = false;
        int startIndex = 0;

        for(int i=0;i<strArr.length;i++){
            if(strArr[i] != ' '){
                if(!wordIn){
                    startIndex = i;
                }
                wordIn = true;
                wordOut = false;
            } else {
                if(wordIn && !wordOut) {
                    reverse(strArr, startIndex, i-1);
                }
                wordOut = true;
                wordIn = false;
            }
        }
        if(wordIn & !wordOut){
            reverse(strArr, startIndex, strArr.length-1);
        }
        return new String(strArr);
    }

    static void reverse(char[] str, int l, int h){
        while(l<h){
            char ch = str[l];
            str[l] = str[h];
            str[h] = ch;
            l++;
            h--;
        }
    }
}
