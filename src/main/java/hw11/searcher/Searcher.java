package hw11.searcher;

public interface Searcher<T extends Comparable<T>> {
    int search(T[] array, T item);
}