package com.example.ds.trie;

import java.util.Scanner;

public class TestDictionary {
    public static void main(String[] args) {
        System.out.println("Loading Dictionary....");
        Dictionary dictionary = Factory.getDictionary();
        System.out.println("Done.");
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Search:");
            String word = in.next();

            if(dictionary.hasWord(word)){
                System.out.println("Found: "+ word );
            } else {
                System.out.println("Not found: "+ word);
            }
            if("quit".equals(word))break;
        }

    }
}
