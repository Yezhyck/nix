package hw15;

import hw15.container.FunctionalInterfacesContainer;

public class FunctionalInterfacesRunner {

    public static void main(String[] args) {
        int numberToCheck = 13;
        int numberToGenerate = 10;
        double numberToRound = 9.81;
        int numberToCalculate = 11;

        System.out.printf("%d is a prime number: %s.%n", numberToCheck, FunctionalInterfacesContainer.checkIfNumbersIsPrime.test(numberToCheck));
        FunctionalInterfacesContainer.generateAndPrintNumberFromZeroToSpecified.accept(numberToGenerate);
        System.out.printf("Today is: %s.%n", FunctionalInterfacesContainer.returnTodayWeekDay.get());
        System.out.printf("%f after rounding is: %d.%n", numberToRound, FunctionalInterfacesContainer.roundDoubleToLong.apply(numberToRound));
        System.out.printf("The %dth fib number is: %d.%n", numberToCalculate, FunctionalInterfacesContainer.calculateFibonacci.apply(numberToCalculate));
    }
}
