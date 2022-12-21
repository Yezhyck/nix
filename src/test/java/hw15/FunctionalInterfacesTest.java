package hw15;

import hw15.container.FunctionalInterfacesContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testing methods of functional interfaces of FunctionalInterfacesContainer class")
class FunctionalInterfacesTest {

    @Test
    @DisplayName("The returned boolean value should be true when a prime number is specified")
    void checkIfNumbersIsPrime_Should_ReturnTrue_When_NumberIsPrime() {
        int number = 13;
        boolean actualResult = FunctionalInterfacesContainer.checkIfNumbersIsPrime.test(number);

        assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("The returned day of the week should match the current day")
    void returnTodayWeekDay_Should_ReturnWednesday_When_TodayIsWednesday() {
        DayOfWeek expectedDayOfWeek = LocalDate.now().getDayOfWeek();

        DayOfWeek actualDayOfWeek = FunctionalInterfacesContainer.returnTodayWeekDay.get();

        assertThat(actualDayOfWeek).isEqualTo(expectedDayOfWeek);
    }

    @Test
    @DisplayName("The returned long value should be equal to the double value rounded according to the rules of mathematics")
    void roundDoubleToLong_Should_ReturnRoundedLongNumberAccordingToMathRules_When_DoubleNumberSpecified() {
        long expectedRoundedNumber = 10;

        double number = 9.81;
        long actualRoundedNumber = FunctionalInterfacesContainer.roundDoubleToLong.apply(number);

        assertThat(actualRoundedNumber).isEqualTo(expectedRoundedNumber);
    }

    @Test
    @DisplayName("The returned Fibonacci number should correspond to the number located in the Fibonacci sequence under the specified index")
    void calculateFibonacci_Should_Return_FibonacciNumber_When_FibonacciNumberIndexSpecified() {
        int expectedFibNumber = 21;

        int number = 8;
        int actualFibNumber = FunctionalInterfacesContainer.calculateFibonacci.apply(number);

        assertThat(actualFibNumber).isEqualTo(expectedFibNumber);
    }
}
