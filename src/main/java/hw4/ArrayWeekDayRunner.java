package hw4;

public class ArrayWeekDayRunner {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        evenNumbers(array);

        WeekDay weekDay = WeekDay.FRIDAY;

        weekDay(weekDay);
    }

    public static void evenNumbers(int[] array) {
        for (int item : array) {
            if (item % 2 == 0) {
                System.out.println(item);
            }
        }
    }

    public static void weekDay(WeekDay weekDay) {
        switch (weekDay) {
            case MONDAY -> System.out.println("It's a monday!");
            case TUESDAY -> System.out.println("It's a tuesday!");
            case WEDNESDAY -> System.out.println("It's a wednesday!");
            case THURSDAY -> System.out.println("It's a thursday!");
            case FRIDAY -> System.out.println("It's a friday!");
            case SATURDAY -> System.out.println("It's a saturday!");
            case SUNDAY -> System.out.println("It's a sunday!");
            default -> System.out.println("It's an unknown day of the week.");
        }
    }
}
