package com.example.ds.string;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings find the maximum length string which is made up of the combination of other strings in the list.
 * Input :[Information, Technology, Batchof2020,
 * InformationTechnology, Batchof2020InformationInternship]
 * <p>
 * Output : InformationTechnology
 * <p>
 * Note:"Batchof2020InformationInternship" is the longest string
 * but its has a sub string Internship which
 * is not a string in the given list, hence its not the output.
 */
public class WordBreakWithMaxWords {
    static Set<String> dictionary = null;
    public static void main(String[] args) {
        String[] words = new String[]{"Information", "Technology", "Batchof2020", "InformationTechnology", "Batchof2020InformationInternship"};
        dictionary = new HashSet<>(Arrays.asList(words));
        String word = findWord( words);
        System.out.println(word);
    }


    static String findWord( String[] word) {
        Word res = new Word("", 0);
        for (String w : word) {
            Word t = wordBreak(w);
            if (t != null && (t.parts > res.parts)) res = t;
        }
        return res.word;
    }

    static Word wordBreak(String word) {
        if(word.isEmpty()) return new Word("", 0);

        for(int i=1;i<=word.length();i++){
            if(dictionary.contains(word.substring(0,i))) {
                Word w = wordBreak(word.substring(i));
                if(w != null){
                    return new Word(word, w.parts+1);
                }
            }
        }
        return null;
    }

    static class Word {
        String word;
        int parts;

        Word(String word, int parts) {
            this.word = word;
            this.parts = parts;
        }
    }
}
