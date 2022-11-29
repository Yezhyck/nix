package hw13;

import hw13.util.NumberUtils;
import hw13.util.WordUtils;

import java.util.List;

public class WordNumberUtilsRunner {

    public static void main(String[] args) {
        List<String> words = List.of("One", "Two", "Two", "Three", "Three", "Four", "Four", "Four", "Five", "Five");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.printf("The shortest word in the list %s is: %s.%n", words, WordUtils.getShortestWord(words));
        System.out.printf("The shortest word in the list %s is: %s. (with comparator)%n", words, WordUtils.getShortestWordWithComparator(words));
        System.out.printf("The number of occurrences of each word in the list %s is: %s.%n%n", words, WordUtils.getWordsOccurrences(words));

        System.out.printf("The sum of all integer elements of the list %s is: %s.%n", numbers, NumberUtils.getSum(numbers));
        System.out.printf("List of all integer values that are odd numbers from the list %s, multiplied by two is: %s.%n", numbers, NumberUtils.multiplyOddNumber(numbers));
    }
}
