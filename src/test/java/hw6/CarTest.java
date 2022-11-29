package hw6;

import hw6.car.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@DisplayName("Testing methods of the Car class")
class CarTest {
    private final Car mercedes = new Car(65, 10, LocalDate.of(2020, 8, 30));
    private final Car bmw = new Car();

    @Test
    @DisplayName("The returned boolean value should be true when the tank's fullness is greater than zero")
    void isAbleToDrive_Should_ReturnTrue_When_TankFullnessGreaterThanZero() {
        Assertions.assertTrue(mercedes.isAbleToDrive());
    }

    @Test
    @DisplayName("The returned boolean value should be false when the tank's fullness is less than zero")
    void isAbleToDrive_Should_ReturnFalse_When_TankFullnessLessThanZeroOrEqualsZero() {
        Assertions.assertFalse(bmw.isAbleToDrive());
    }

    @Test
    @DisplayName("The returned boolean value should be true when two years have not passed since the date of the inspection")
    void isApprovedForUse_Should_ReturnTrue_When_TwoYearsHaveNotPassedSinceInspectionDate() {
        Assertions.assertTrue(mercedes.isApprovedForUse());
    }

    @Test
    @DisplayName("The boolean return value should be false when no inspection date is specified")
    void isApprovedForUse_Should_ReturnTrue_When_InspectionDateNotSpecified() {
        Assertions.assertFalse(bmw.isApprovedForUse());
    }

    @Test
    @DisplayName("The returned integer value should equal to the distance remaining to drive")
    void distanceRemainingToDrive_Should_ReturnDistanceRemainingToDrive_When_FuelConsumptionPerThunderedKmSpecified() {
        int mercedesDistanceRemainingToDrive = 650;

        Assertions.assertEquals(mercedesDistanceRemainingToDrive, mercedes.distanceRemainingToDrive());
    }

    @Test
    @DisplayName("The returned integer value should be zero when no distance remaining to drive is specified")
    void distanceRemainingToDrive_Should_ReturnZero_When_FuelConsumptionPerThunderedKmNotSpecified() {
        int bmwDistanceRemainingToDrive = 0;

        Assertions.assertEquals(bmwDistanceRemainingToDrive, bmw.distanceRemainingToDrive());
    }
}