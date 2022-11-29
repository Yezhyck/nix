package hw14.car.camparator;

import hw14.car.Car;

import java.util.Comparator;

public class CarYearOfManufactureComparator implements Comparator<Car> {
    @Override
    public int compare(Car firstCar, Car secondCar) {
        return Integer.compare(firstCar.getYearOfManufacture(), secondCar.getYearOfManufacture());
    }
}
