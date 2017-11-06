package com.example.ds.trie;


public class Factory {
    public static Dictionary getDictionary() {
        Dictionary dictionary = new DictionaryImpl();
        DictionaryLoader.load(dictionary);
        return dictionary;
    }
}
