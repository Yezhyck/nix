package hw2;

import java.util.Random;

public class YourLuckyNumberRunner {

    public static void main(String[] args) {
        int yourLuckyNumber = new Random().nextInt(10);

        System.out.printf("Your lucky number %d.", yourLuckyNumber);
    }
}
