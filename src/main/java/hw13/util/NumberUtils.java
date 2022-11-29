package hw13.util;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public static int getSum(List<Integer> numbers) {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static List<Integer> multiplyOddNumber(List<Integer> numbers) {
        List<Integer> multipliedByTwoOddNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (isOdd(number)) {
                multipliedByTwoOddNumbers.add(number * 2);
            }
        }

        return multipliedByTwoOddNumbers;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
