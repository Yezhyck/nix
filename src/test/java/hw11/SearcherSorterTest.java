package hw11;

import hw11.searcher.BinarySearcher;
import hw11.sorter.BubbleSorter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing methods of the BinarySearcher and BubbleSorter classes")
class SearcherSorterTest {
    private final Integer[] integersArray = new Integer[]{0, 1, 2, 3, 3, 4, 4, 5, 7, 9, 10};
    private final Double[] doublesArray = new Double[]{0.835, 0.91, 1.02, 1.74, 2.5, 3.068, 3.903, 4.72, 6.029, 15.88};
    private final String[] stringsArray = new String[]{"Absolute", "Beginning", "Code", "Density", "Embarrassment", "Force", "Irregular", "Quality", "Rotation", "Source"};

    private BinarySearcher<Integer> integerBinarySearcher;
    private BinarySearcher<Double> doubleBinarySearcher;
    private BinarySearcher<String> stringBinarySearcher;

    private BubbleSorter<Integer> integerBubbleSorter;
    private BubbleSorter<Double> doubleBubbleSorter;
    private BubbleSorter<String> stringBubbleSorter;

    @BeforeAll
    void initialize() {
        integerBinarySearcher = new BinarySearcher<>();
        doubleBinarySearcher = new BinarySearcher<>();
        stringBinarySearcher = new BinarySearcher<>();

        integerBubbleSorter = new BubbleSorter<>();
        doubleBubbleSorter = new BubbleSorter<>();
        stringBubbleSorter = new BubbleSorter<>();
    }

    @Test
    @DisplayName("The returned array should be sorted in ascending order")
    void sort_Should_ReturnSortedArray_When_ArrayIsUnsorted() {
        Integer[] actualIntegersArray = new Integer[]{9, 3, 0, 4, 7, 10, 2, 5, 1, 4, 3};
        Double[] actualDoublesArray = new Double[]{3.903, 0.835, 6.029, 15.88, 3.068, 1.74, 0.91, 1.02, 4.72, 2.5};
        String[] actualStringsArray = new String[]{"Force", "Code", "Rotation", "Source", "Absolute", "Quality", "Density", "Irregular", "Embarrassment", "Beginning"};

        assertArrayEquals(integersArray, integerBubbleSorter.sort(actualIntegersArray));
        assertArrayEquals(doublesArray, doubleBubbleSorter.sort(actualDoublesArray));
        assertArrayEquals(stringsArray, stringBubbleSorter.sort(actualStringsArray));
    }

    @Test
    @DisplayName("The returned index should point to the location of the specified element in the array")
    void search_Should_ReturnElementIndex_When_ArrayContainsSpecifiedElement() {
        Integer searchedInteger = 7;
        Double searchedDouble = 1.02;
        String searchedString = "Force";

        int searchedIntegerExpectedIndex = 8;
        int searchedDoubleExpectedIndex = 2;
        int searchedStringExpectedIndex = 5;

        assertEquals(searchedIntegerExpectedIndex, integerBinarySearcher.search(integersArray, searchedInteger));
        assertEquals(searchedDoubleExpectedIndex, doubleBinarySearcher.search(doublesArray, searchedDouble));
        assertEquals(searchedStringExpectedIndex, stringBinarySearcher.search(stringsArray, searchedString));
    }

    @Test
    @DisplayName("The returned index should be negative because the array does not contain the specified element")
    void search_Should_ReturnNegativeIndex_When_ArrayDoesNotContainSpecifiedElement() {
        Integer searchedInteger = -13;
        Double searchedDouble = 5.632;
        String searchedString = "Loop";

        int expectedIndex = -1;

        assertEquals(expectedIndex, integerBinarySearcher.search(integersArray, searchedInteger));
        assertEquals(expectedIndex, doubleBinarySearcher.search(doublesArray, searchedDouble));
        assertEquals(expectedIndex, stringBinarySearcher.search(stringsArray, searchedString));
    }
}