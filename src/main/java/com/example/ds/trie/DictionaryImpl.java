package com.example.ds.trie;

import java.util.LinkedList;
import java.util.List;

public class DictionaryImpl implements  Dictionary{

    Node root = new Node('/');
    @Override
    public boolean hasWord(String word) {
        Node itr = root;
        for(char ch : word.toCharArray()){
            if(!itr.childeren.containsKey(ch)) return false;
            itr = itr.childeren.get(ch);
        }
        return itr.isWord();
    }

    @Override
    public void addWord(String word) {
        Node itr = root;
        for(char ch : word.toCharArray()){
            if(!itr.childeren.containsKey(ch)){
                Node letter = new Node(ch);
                itr.childeren.put(ch, letter);
            }
            itr = itr.childeren.get(ch);
        }
        itr.setWord(true);
    }

    @Override
    public void removeWord(String word) {

    }

    @Override
    public List<String> getWords(String startsWith) {
        return null;
    }


}
