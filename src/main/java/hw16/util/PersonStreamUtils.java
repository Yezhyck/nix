package hw16.util;

import hw16.person.Person;
import hw16.person.Sex;
import lombok.NonNull;

import java.util.List;

public class PersonStreamUtils {
    public static List<Person> chooseWomenOverEighteenAndUnderSixty(@NonNull List<Person> people) {
        return people.stream()
                .filter(PersonStreamUtils::isWomenOverEighteenAndUnderSixty)
                .toList();
    }

    public static Double findAverageMenAge(@NonNull List<Person> people) {
        return people.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public static Long findAbleBodiedPeopleNumber(@NonNull List<Person> people) {
        return people.stream()
                .filter(PersonStreamUtils::isAbleBodiedPerson)
                .count();
    }

    private static boolean isWomenOverEighteenAndUnderSixty(Person person) {
        return person.getSex().equals(Sex.WOMAN) && (18 <= person.getAge() && person.getAge() < 60);
    }

    private static boolean isAbleBodiedPerson(Person person) {
        return person.getAge() >= 18 && ((person.getSex().equals(Sex.WOMAN) && person.getAge() < 55) || (person.getSex().equals(Sex.MAN) && person.getAge() < 60));
    }
}
