package hw17;

import hw16.person.Person;
import hw16.person.Sex;
import hw17.util.NioUtils;

import java.util.List;

public class NioUtilsRunner {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("John", 38, Sex.MAN),
                new Person("Marry", 21, Sex.WOMAN),
                new Person("Kate", 45, Sex.WOMAN),
                new Person("Bart", 18, Sex.MAN),
                new Person("Luiza", 69, Sex.WOMAN)
        );
        String imageFileUrl = "https://pbs.twimg.com/profile_images/1509961758022139904/fXryqX_6_400x400.jpg";

        NioUtils.createEmptyDirectory();
        NioUtils.createCsvFile();
        NioUtils.writePersonsToCsvFile(persons);
        NioUtils.loadImageFileByUrl(imageFileUrl);
//        NioUtils.reset();
    }
}
