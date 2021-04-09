package ru.grutsinav;

import java.util.*;


public class WorkWithArray {
    private final String[] words;
    private final Set<String> setWords;

    WorkWithArray(String[] words){
        this.words = words;
        this.setWords = new HashSet<>();
    }

    public Set<String> arrayWithOutDuplicate(){
        setWords.addAll(Arrays.asList(words));
        return setWords;
    }

    public HashMap<String, Integer> volumeOfWordsInArray(){
        HashMap<String, Integer> hashMapWords = new HashMap<>();
        for (String word: words){
            hashMapWords.put(word, hashMapWords.getOrDefault(word, 0) + 1);
        }
        return hashMapWords;
        }
    }

