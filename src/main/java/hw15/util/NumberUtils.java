package hw15.util;

public class NumberUtils {
    public static boolean isPrime(int number) {
        return isPrime(number, number);
    }

    private static boolean isPrime(int number, int divider) {
        if (number <= 2)
            return number == 2;
        if (divider < 2)
            return true;
        if (divider != number && number % divider == 0)
            return false;

        return isPrime(number, divider - 1);
    }

    public static int fibonacci(int number) {
        if (number <= 1)
            return number;

        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
