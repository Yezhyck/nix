package hw14;

import hw14.car.Car;
import hw14.car.camparator.CarEngineCapacityComparator;
import hw14.car.camparator.CarYearOfManufactureComparator;
import hw14.range.Range;
import hw14.range.RangeWithStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorsIteratorsRunner {

    public static void main(String[] args) {
        Car car1 = new Car(2018, 1.6);
        Car car2 = new Car(2020, 7.4);
        Car car3 = new Car(2015, 2.2);
        Car car4 = new Car(2022, 3.5);
        Car car5 = new Car(2019, 6.8);

        List<Car> cars = List.of(car1, car2, car3, car4, car5);

        CarYearOfManufactureComparator byYearOfManufacture = new CarYearOfManufactureComparator();
        CarEngineCapacityComparator byEngineCapacity = new CarEngineCapacityComparator();

        List<Car> carList = new ArrayList<>(cars);
        Set<Car> carSet = new TreeSet<>(byEngineCapacity.reversed());

        carList.sort(byYearOfManufacture);
        carSet.addAll(cars);

        System.out.printf("List of cars %s after sorting by year of manufacture in ascending order is: %s.%n", cars, carList);
        System.out.printf("List of cars %s after sorting by engine volume in descending order is: %s.%n%n", cars, carSet);

        int start = 1;
        int positiveEnd = 10;
        int negativeEnd = -10;
        int step = 2;

        for (Integer integer : new Range(start, positiveEnd)) {
            System.out.printf("Integer item of the range(start: %d, end: %d) is: %d.%n", start, positiveEnd, integer);
        }

        for (Integer integer : new Range(start, negativeEnd)) {
            System.out.printf("Integer item of the range(start: %d, end: %d) is: %d.%n", start, negativeEnd, integer);
        }

        for (Integer integer : new RangeWithStep(start, positiveEnd, step)) {
            System.out.printf("Integer item of the range(start: %d, end: %d, step: %d) is: %d.%n", start, positiveEnd, step, integer);
        }

        for (Integer integer : new RangeWithStep(start, negativeEnd, step)) {
            System.out.printf("Integer item of the range(start: %d, end: %d, step: %d) is: %d.%n", start, negativeEnd, step, integer);
        }
    }
}
