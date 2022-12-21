package hw16.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person {
    private String name;
    private Integer age;
    private Sex sex;
}
