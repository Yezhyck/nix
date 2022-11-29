package hw10.cat;

public class Cat extends Predator {
    private final CatBreed breed;

    public Cat(Color color, int weight, CatBreed breed) {
        super(color, weight);
        this.breed = breed;
    }

    @Override
    public Activity sleep() {
        return Activity.SLEEP;
    }

    @Override
    public Activity hunt() {
        return Activity.HUNT;
    }

    public Activity mate() {
        return Activity.MATE;
    }

    public Activity lickEggs() {
        return Activity.LICK_EGGS;
    }

    public Activity weekActivity(WeekDay weekDay) {
        return switch (weekDay) {
            case MONDAY, WEDNESDAY, FRIDAY -> sleep();
            case TUESDAY, THURSDAY, SATURDAY -> hunt();
            case SUNDAY -> mate();
            default -> lickEggs();
        };
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color=" + super.getColor() +
                ", weight=" + super.getWeight() +
                ", breed=" + breed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return breed == cat.breed && super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = breed.hashCode();
        result = 31 * result + super.hashCode();
        return result;
    }
}
