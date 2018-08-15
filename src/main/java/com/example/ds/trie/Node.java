package com.example.ds.trie;

import java.util.Map;
import java.util.TreeMap;

public class Node {
    private char letter;
    private boolean word;
    Map<Character, Node> childeren = new TreeMap<>();
    public Node(char letter){
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
    }

    public Map<Character, Node> getChilderen() {
        return childeren;
    }

    public void setChilderen(Map<Character, Node> childeren) {
        this.childeren = childeren;
    }
}
