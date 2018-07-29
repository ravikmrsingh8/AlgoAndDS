package com.example.ds.trie;

public class TestDictionary {
    public static void main(String[] args) {
        Dictionary dictionary = Factory.getDictionary();
        System.out.println("Looking for word dictionary.... ");
        boolean found = dictionary.hasWord("dictionary");
        System.out.println((!found?"not":"")+ "found");
    }
}
