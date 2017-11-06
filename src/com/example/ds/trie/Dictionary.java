package com.example.ds.trie;

import java.util.List;

public interface Dictionary {
    boolean hasWord(String word);
    void addWord(String word);
    void removeWord(String word);

    //Get All words that starts with given string
    List<String> getWords(String startsWith);
}
