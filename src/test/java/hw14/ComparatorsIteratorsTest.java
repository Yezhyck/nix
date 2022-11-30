package hw14;

import hw14.car.Car;
import hw14.car.camparator.CarEngineCapacityComparator;
import hw14.car.camparator.CarYearOfManufactureComparator;
import hw14.range.Range;
import hw14.range.RangeWithStep;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing methods of the CarEngineCapacityComparator, CarYearOfManufactureComparator, RangeIterator and RangeWithStepIterator classes")
class ComparatorsIteratorsTest {
    private final CarYearOfManufactureComparator yearOfManufactureComparator = new CarYearOfManufactureComparator();
    private final CarEngineCapacityComparator engineCapacityComparator = new CarEngineCapacityComparator();

    private final List<Car> carList = new ArrayList<>();
    private final Set<Car> carSet = new TreeSet<>(engineCapacityComparator.reversed());

    private final Car car1 = new Car(2018, 1.6);
    private final Car car2 = new Car(2020, 7.4);
    private final Car car3 = new Car(2015, 2.2);
    private final Car car4 = new Car(2022, 3.5);
    private final Car car5 = new Car(2019, 6.8);

    private final int start = 1;
    private final int end = 10;
    private final int step = 2;
    private final int last = 9;

    @BeforeAll
    void initialize() {
        List<Car> cars = List.of(car1, car2, car3, car4, car5);

        carList.addAll(cars);
        carSet.addAll(cars);
    }

    @Test
    @DisplayName("The list of cars should be sorted by year of manufacture in ascending order")
    void compareByYearOfManufacture_Should_SortCarsListByYearOfManufactureInAscendingOrder_When_ComparesCarsByYearOfManufacture() {
        List<Car> sortedByYearOfManufactureInAscendingOrderCarList = List.of(car3, car1, car5, car2, car4);

        carList.sort(yearOfManufactureComparator);

        assertThat(carList).containsExactlyElementsOf(sortedByYearOfManufactureInAscendingOrderCarList);
    }

    @Test
    @DisplayName("The list of cars should be sorted by engine size in descending order")
    void compareByEngineCapacity_Should_SortCarsListByEngineCapacityInDescendingOrder_When_ComparesCarsByEngineCapacity() {
        List<Car> reversedSortedByEngineCapacityInDescendingOrderCarList = List.of(car2, car5, car4, car3, car1);

        assertThat(carSet).containsExactlyElementsOf(reversedSortedByEngineCapacityInDescendingOrderCarList);
    }

    @Test
    @DisplayName("The returned iterator should iterate over an increasing sequence of integers when the start value is less than the end value")
    void range_Should_ReturnIteratorWhichIteratesOverIncreasingSequence_When_StartValueLessThanEndValue() {
        Range startLessThanEndRange = new Range(start, end);

        assertThat(startLessThanEndRange).startsWith(start).endsWith(last);
    }

    @Test
    @DisplayName("The returned iterator should iterate over a descending sequence of integers when the start value is greater than the end value")
    void range_Should_ReturnIteratorWhichIteratesOverDecreasingSequence_When_StartValueGraterThanEndValue() {
        Range startGreaterThanEndRange = new Range(start, -end);

        assertThat(startGreaterThanEndRange).startsWith(start).endsWith(-last);
    }

    @Test
    @DisplayName("The returned iterator should iterate over an increasing sequence of integers with positive step value when the start value is less than the end value")
    void rangeWithStep_Should_ReturnIteratorWhichIteratesOverIncreasingSequenceWithPositiveStepValue_When_StartValueLessThanEndValue() {
        RangeWithStep startLessThanEndRangeWithStep = new RangeWithStep(start, end, step);

        assertThat(startLessThanEndRangeWithStep).startsWith(start).endsWith(last);
    }

    @Test
    @DisplayName("The returned iterator should iterate over a descending sequence of integers with positive step value when the start value is greater than the end value")
    void rangeWithStep_Should_ReturnIteratorWhichIteratesOverDecreasingSequenceWithPositiveStepValue_When_StartValueGreaterThanEndValue() {
        RangeWithStep startGreaterThanEndRangeWithStep = new RangeWithStep(start, -end, step);

        assertThat(startGreaterThanEndRangeWithStep).startsWith(start).endsWith(-last);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5})
    @DisplayName("An exception should be thrown when a zero or negative step value is specified")
    void rangeWithStep_Should_ThrowException_When_ZeroOrNegativeStepValueSpecified(int step) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RangeWithStep(start, end, step))
                .withMessage("Step must have a positive value");
    }
}
