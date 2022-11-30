package hw11.sorter;

public interface Sorter<T extends Comparable<T>> {
    T[] sort(T[] array);
}
