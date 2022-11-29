package hw5;

import hw5.util.NumberUtils;

public class NumberUtilsRunner {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (NumberUtils.isPrime(i)) {
                System.out.printf("%d is a prime number.%n", i);
            }
        }
    }
}
