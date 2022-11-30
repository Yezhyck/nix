package hw10.cat;

public abstract class Predator {
    private final Color color;
    private final int weight;

    protected Predator(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public abstract Activity sleep();

    public abstract Activity hunt();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predator predator = (Predator) o;
        return predator.weight == weight && color == predator.color;
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + weight;
        return result;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }
}
