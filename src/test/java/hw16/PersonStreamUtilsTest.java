package hw16;

import hw16.person.Person;
import hw16.person.Sex;
import hw16.util.PersonStreamUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing methods of PersonStreamUtils class")
class PersonStreamUtilsTest {
    private static final Person john = new Person("John", 38, Sex.MAN);
    private static final Person marry = new Person("Marry", 21, Sex.WOMAN);
    private static final Person kate = new Person("Kate", 45, Sex.WOMAN);
    private static final Person bart = new Person("Bart", 18, Sex.MAN);
    private static final Person luiza = new Person("Luiza", 69, Sex.WOMAN);
    private static List<Person> people;

    @BeforeAll
    void initialize() {
        people = List.of(john, marry, kate, bart, luiza);
    }

    @Test
    @DisplayName("The returned list of people should consist of women over eighteen and under sixty")
    void chooseWomenOverEighteenAndUnderSixty_Should_ReturnPersonList_When_TheyAreWomenOverEighteenAndUnderSixty() {
        List<Person> expectedWomenOverEighteenAndUnderSixtyList = List.of(marry, kate);

        List<Person> actualWomenOverEighteenAndUnderSixtyList = PersonStreamUtils.chooseWomenOverEighteenAndUnderSixty(people);

        assertThat(actualWomenOverEighteenAndUnderSixtyList).containsExactlyElementsOf(expectedWomenOverEighteenAndUnderSixtyList);
    }

    @Test
    @DisplayName("The returned double value should equal the average age of the men in the list of people")
    void findAverageMenAge_Should_ReturnPeopleAverageAge_When_TheyAreMen() {
        double expectedAverageMenAge = 28;

        double actualAverageMenAge = PersonStreamUtils.findAverageMenAge(people);

        assertThat(actualAverageMenAge).isEqualTo(expectedAverageMenAge);
    }

    @Test
    @DisplayName("The returned double value must be zero, because the list of people is empty")
    void findAverageMenAge_Should_ReturnZero_When_PersonListIsEmpty() {
        double expectedAverageMenAge = 0;

        double actualAverageMenAge = PersonStreamUtils.findAverageMenAge(List.of());

        assertThat(actualAverageMenAge).isEqualTo(expectedAverageMenAge);
    }

    @Test
    @DisplayName("The returned long value should be equal to the number of able-bodied people")
    void findAbleBodiedPeopleNumber_Should_ReturnPeopleNumber_When_TheyAreAbleBodied() {
        long expectedAbleBodiedPeopleNumber = 4;

        long actualAbleBodiedPeopleNumber = PersonStreamUtils.findAbleBodiedPeopleNumber(people);

        assertThat(actualAbleBodiedPeopleNumber).isEqualTo(expectedAbleBodiedPeopleNumber);
    }
}
