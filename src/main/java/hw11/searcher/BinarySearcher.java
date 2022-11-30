package hw11.searcher;

public class BinarySearcher<T extends Comparable<T>> implements Searcher<T> {
    @Override
    public int search(T[] array, T item) {
        return search(array, item, 0, array.length - 1);
    }

    private int search(T[] array, T item, int left, int right) {
        if (left <= right) {
            int mod = left + (right - left) / 2;
            if (array[mod].compareTo(item) < 0)
                return search(array, item, mod + 1, right);
            else if (array[mod].compareTo(item) > 0)
                return search(array, item, left, mod - 1);
            else return mod;
        }
        return -1;
    }
}