package hw10;

import hw10.cat.Cat;
import hw10.cat.CatBreed;
import hw10.cat.Color;
import hw10.cat.WeekDay;

public class CatRunner {

    public static void main(String[] args) {
        Cat leo = new Cat(Color.BLACK, 5, CatBreed.BENGAL);
        WeekDay[] weekDays = new WeekDay[]{
                WeekDay.MONDAY,
                WeekDay.TUESDAY,
                WeekDay.WEDNESDAY,
                WeekDay.THURSDAY,
                WeekDay.FRIDAY,
                WeekDay.SATURDAY,
                WeekDay.SUNDAY,
                WeekDay.UNKNOWN_DAY
        };

        for (WeekDay weekDay : weekDays) {
            System.out.printf("%s %ss on %s.%n", leo, leo.weekActivity(weekDay), weekDay);
        }
    }
}
