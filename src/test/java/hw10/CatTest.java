package hw10;

import hw10.cat.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing methods of the Cat class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CatTest {
    private Cat cat;

    @BeforeAll
    void initialize() {
        cat = new Cat(Color.BROWN, 4, CatBreed.BENGAL);
    }

    @ParameterizedTest
    @MethodSource("objects")
    @DisplayName("The return boolean value of the comparison of two objects should match their equality")
    void equals_Should_ReturnTrue_When_ObjectsAreEquals(Object object, boolean isEquals) {
        assertEquals(isEquals, cat.equals(object));
    }

    @ParameterizedTest
    @EnumSource(WeekDay.class)
    @DisplayName("The returned enum type of weekly activity should match the day of the week that the activity occurs")
    void weekActivity_Should_ReturnWeekActivity_When_WeekActivityMatchWeekDay(WeekDay weekDay) {
        Activity activity = cat.weekActivity(weekDay);

        switch (weekDay) {
            case MONDAY, WEDNESDAY, FRIDAY -> assertEquals(Activity.SLEEP, activity);
            case TUESDAY, THURSDAY, SATURDAY -> assertEquals(Activity.HUNT, activity);
            case SUNDAY -> assertEquals(Activity.MATE, activity);
            default -> assertEquals(Activity.LICK_EGGS, activity);
        }
    }

    private List<Arguments> objects() {
        return List.of(
                Arguments.of(null, false),
                Arguments.of(new Object(), false),
                Arguments.of(new Cat(Color.BLACK, 5, CatBreed.HAVANA), false),
                Arguments.of(new Cat(Color.BROWN, 4, CatBreed.BENGAL), true),
                Arguments.of(cat, true)
        );
    }
}
