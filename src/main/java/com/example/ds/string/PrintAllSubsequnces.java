package com.example.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a string you need to print all its sub possible combinations of String using same characters
 * in lexicographic order. Example:
 * Input :  ABC
 * Output : A AB ABC AC ACB B BA BAC BC BCA C CA CB CAB CBA
 */
public class PrintAllSubsequnces {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> list = getList(str);
        System.out.println(list);
    }

    static List<String> getList(String str){
        List<String> list = new ArrayList<>();
        list.add(str.charAt(0)+"");

        for(int i=1;i<str.length();i++){
            List<String> newList = new ArrayList<>(list);
            for(String word: list){
                for(int j=0;j<=word.length();j++){
                    newList.add(word.substring(0,j)+ str.charAt(i)+word.substring(j));
                }
            }
            newList.add(str.charAt(i)+"");
            list = newList;
        }
        list.sort(String::compareTo);
        return list;
    }
}
