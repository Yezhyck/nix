package hw15.container;

import hw15.util.NumberUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesContainer {
    public static final Predicate<Integer> checkIfNumbersIsPrime = NumberUtils::isPrime;
    public static final Consumer<Integer> generateAndPrintNumberFromZeroToSpecified = border -> System.out.println(new Random().nextInt(0, border));
    public static final Supplier<DayOfWeek> returnTodayWeekDay = () -> LocalDate.now().getDayOfWeek();
    public static final Function<Double, Long> roundDoubleToLong = Math::round;
    public static final UnaryOperator<Integer> calculateFibonacci = NumberUtils::fibonacci;
}
