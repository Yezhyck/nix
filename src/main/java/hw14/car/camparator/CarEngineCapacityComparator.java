package hw14.car.camparator;

import hw14.car.Car;

import java.util.Comparator;

public class CarEngineCapacityComparator implements Comparator<Car> {
    @Override
    public int compare(Car firstCar, Car secondCar) {
        return Double.compare(firstCar.getEngineCapacity(), secondCar.getEngineCapacity());
    }
}
