package hw11.sorter;

public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public T[] sort(T[] array) {
        int swapAmount;
        do {
            swapAmount = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapAmount++;
                }
            }
        } while (swapAmount != 0);
        return array;
    }

    private void swap(T[] array, int leftIndex, int rightIndex) {
        T item = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = item;
    }
}
