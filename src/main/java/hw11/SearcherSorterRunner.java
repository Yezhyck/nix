package hw11;

import hw11.searcher.BinarySearcher;
import hw11.sorter.BubbleSorter;

import java.util.Arrays;

public class SearcherSorterRunner {

    public static void main(String[] args) {
        BubbleSorter<Integer> integerBubbleSorter = new BubbleSorter<>();
        BinarySearcher<Integer> integerBinarySearcher = new BinarySearcher<>();

        Integer[] integers = new Integer[]{3, 1, 7, 4, 9, 0, 3, 4, 5, 10};
        int number = 4;

        System.out.printf("Array %s after sorting: %s.%n", Arrays.toString(integers), Arrays.toString(integerBubbleSorter.sort(integers)));
        System.out.printf("The index of the element \"%s\" of the array %s is: %d.%n", number, Arrays.toString(integers), integerBinarySearcher.search(integers, number));
    }
}
