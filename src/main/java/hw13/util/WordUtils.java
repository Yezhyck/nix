package hw13.util;

import lombok.NonNull;

import java.util.*;

public class WordUtils {

    public static String getShortestWord(@NonNull List<String> words)  {
        String shortestWord = words.get(0);

        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        return shortestWord;
    }

    public static String getShortestWordWithComparator(@NonNull List<String> words)  {
        Set<String> wordsSortedByLength = new TreeSet<>(Comparator.comparingInt(String::length));

        wordsSortedByLength.addAll(words);

        return String.valueOf(wordsSortedByLength.toArray()[0]);
    }

    public static Map<String, Integer> getWordsOccurrences(List<String> sentence) {
        Map<String, Integer> wordsInputsInSentence = new LinkedHashMap<>();

        for (String word : sentence) {
            wordsInputsInSentence.put(word, wordsInputsInSentence.containsKey(word) ? wordsInputsInSentence.get(word) + 1 : 1);
        }

        return wordsInputsInSentence;
    }
}
