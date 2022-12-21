package hw17.mapper;

import hw16.person.Person;

public class PersonCsvMapper implements CsvMapper<Person> {
    @Override
    public String toCsv(Person object) {
        return object.getName() + ", " + object.getAge() + ", " + object.getSex();
    }
}
