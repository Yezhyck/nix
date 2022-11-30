package hw13;

import hw13.util.NumberUtils;
import hw13.util.WordUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing methods of the WordUtils and NumberUtils classes")
class WordNumberUtilsTest {
    private static final List<String> words = List.of("One", "Two", "Two", "Three", "Three", "Four", "Four", "Four", "Five", "Five");
    private static final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    @DisplayName("The returned string value should match the shortest word in the specified list of strings")
    void getShortestWord_Should_ReturnStringValue_When_FindsShortestWord() {
        String expectedShortestWord = "One";
        String actualShortestWord = WordUtils.getShortestWord(words);

        assertEquals(expectedShortestWord, actualShortestWord);
    }

    @Test
    @DisplayName("The returned string value should match the shortest word in the specified list of strings")
    void getShortestWordWithComparator_Should_ReturnStringValue_When_FindsShortestWord() {
        String expectedShortestWord = "One";
        String actualShortestWord = WordUtils.getShortestWordWithComparator(words);

        assertEquals(expectedShortestWord, actualShortestWord);
    }

    @Test
    @DisplayName("The returned string-integer map should consist of pairs, where the word is represented as a key, and the number of occurrences of this word is represented as a value")
    void getWordsOccurrences_Should_ReturnStringIntegerMap_When_CountsWordsOccurrences() {
        Map<String, Integer> expectedWordsOccurrences = Map.of("One", 1, "Two", 2, "Three", 2, "Four", 3, "Five", 2);
        Map<String, Integer> actualWordsOccurrences = WordUtils.getWordsOccurrences(words);

        assertEquals(expectedWordsOccurrences, actualWordsOccurrences);
    }

    @Test
    @DisplayName("The returned integer value should equal the sum of all elements in the list")
    void getSum_Should_ReturnIntegerValue_When_CalculatesDigitsSum() {
        int expectedSum = 55;
        int actualSum = NumberUtils.getSum(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    @DisplayName("The returned integer list should consist of integer values that are odd numbers multiplied by two")
    void multiplyOddNumber_Should_ReturnIntegerList_When_FindsAndMultiplyByTwoOddNumbers() {
        List<Integer> expectedMultipliedOddNumbers = List.of(2, 6, 10, 14, 18);
        List<Integer> actualMultipliedOddNumbers = NumberUtils.multiplyOddNumber(numbers);

        assertEquals(expectedMultipliedOddNumbers, actualMultipliedOddNumbers);
    }
}
