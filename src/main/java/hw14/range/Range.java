package hw14.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    protected final int start;
    protected final int end;

    protected final int size;
    protected final int[] sequence;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;

        boolean toIncrease = start < end;
        size = toIncrease ? end - start : start - end;
        sequence = new int[size];

        for (int i = 0; i < size; i++) {
            sequence[i] = toIncrease ? start + i : start - i;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    class RangeIterator implements Iterator<Integer> {
        private int current;

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return sequence[current++];
        }
    }
}
