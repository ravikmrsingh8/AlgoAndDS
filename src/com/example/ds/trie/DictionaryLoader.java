package com.example.ds.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DictionaryLoader {
    static void load(Dictionary dictionary) {
        InputStream in = DictionaryLoader.class.getResourceAsStream("/com/example/ds/trie/words.txt");
        try {
            load(in, dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void load(InputStream in, Dictionary dictionary) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String word = null;
        while ((word = br.readLine()) != null) {
            word = word.trim();
            if (!word.isEmpty()) {
                dictionary.addWord(word);
            }
        }
    }
}
