package hw14.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeWithStep extends Range {
    private final int step;

    public RangeWithStep(int start, int end, int step) {
        super(start, end);
        if (step <= 0) {
            throw new IllegalArgumentException("Step must have a positive value");
        }
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeWithStepIterator();
    }

    class RangeWithStepIterator implements Iterator<Integer> {
        private int current;

        public RangeWithStepIterator() {
            current = -step;
        }

        @Override
        public boolean hasNext() {
            return (current + step) < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current += step;
            return sequence[current];
        }
    }
}
