package com.example.ds.string;

import com.example.ds.trie.Dictionary;
import com.example.ds.trie.Factory;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Dictionary words which are 1 or 2 distance away from given words
 * <p>
 * to make a good suggestion we also need to have a Map which has most popular words with count
 * <p>
 * if we get 100 words which are 1 or 2 distance away
 * we will create a min heap based on popularity to store say 10 suggestion , we will iterate through the 100 suggestion
 * and put them in the heap if they are more  popular than one on the top
 */
public class DictionaryStrings10r2DistanceAway {
    static Dictionary dictionary = Factory.getDictionary();

    public static void main(String[] args) {
        String word = "hlep";
        findSuggestions(word).forEach(System.out::println);
    }

    // Will return words 1 or 2 distance away
    static Set<String> findSuggestions(String word) {
        Set<String> words = edits1(word);
        Set<String> suggestions = new LinkedHashSet<>(words);
        for (String w : words) {
            suggestions.addAll(edits1(w));
        }
        return suggestions;
    }

    //Returns word 1 distance away
    static Set<String> edits1(String word) {
        String alphbet = "abcdefghijklmnopqrstuvwxyz";
        Set<String> inserts = new LinkedHashSet<>();
        for (char ch : alphbet.toCharArray()) {
            for (int i = 0; i <= word.length(); i++) {
                String newWord = word.substring(0, i) + ch + word.substring(i);
                if (dictionary.hasWord(newWord)) inserts.add(newWord);
            }
        }

        Set<String> deletes = new LinkedHashSet<>();
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if (dictionary.hasWord(newWord)) deletes.add(newWord);
        }

        Set<String> updates = new LinkedHashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch : alphbet.toCharArray()) {
                String newWord = word.substring(0, i) + ch + word.substring(i + 1);
                if (dictionary.hasWord(newWord)) updates.add(newWord);
            }
        }

        Set<String> set = new LinkedHashSet<>();
        set.addAll(inserts);
        set.addAll(deletes);
        set.addAll(updates);
        return set;
    }
}
