package hw6;

import hw6.car.Car;

import java.time.LocalDate;

public class CarRunner {

    public static void main(String[] args) {
        Car mercedes = new Car(65, 10, LocalDate.of(2020, 8, 30));
        Car bmw = new Car();

        System.out.printf("%s can drive: %s.%n", mercedes, mercedes.isAbleToDrive());
        System.out.printf("%s can drive: %s.%n%n", bmw, bmw.isAbleToDrive());

        System.out.printf("%s approved for use: %s.%n", mercedes, mercedes.isApprovedForUse());
        System.out.printf("%s approved for use: %s.%n%n", bmw, bmw.isApprovedForUse());

        System.out.printf("Remaining distance to drive for %s is: %s.%n", mercedes, mercedes.distanceRemainingToDrive());
        System.out.printf("Remaining distance to drive for %s is: %s.%n%n", bmw, bmw.distanceRemainingToDrive());
    }
}
