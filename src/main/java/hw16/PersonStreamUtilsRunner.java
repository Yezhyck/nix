package hw16;

import hw16.person.Person;
import hw16.person.Sex;
import hw16.util.PersonStreamUtils;

import java.util.List;

public class PersonStreamUtilsRunner {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", 38, Sex.MAN),
                new Person("Marry", 21, Sex.WOMAN),
                new Person("Kate", 45, Sex.WOMAN),
                new Person("Bart", 18, Sex.MAN),
                new Person("Luiza", 69, Sex.WOMAN)
        );

        System.out.printf("All woman from the list %s with age from eighteen to sixty: %s.%n", people, PersonStreamUtils.chooseWomenOverEighteenAndUnderSixty(people));
        System.out.printf("The average age of men from the list %s is: %f.%n", people, PersonStreamUtils.findAverageMenAge(people));
        System.out.printf("Amount of workable people from the list %s is: %d.%n", people, PersonStreamUtils.findAbleBodiedPeopleNumber(people));
    }
}
