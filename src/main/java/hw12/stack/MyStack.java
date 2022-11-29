package hw12.stack;

import hw12.stack.exception.*;

import java.util.Arrays;
import java.util.Optional;

public class MyStack<E> implements Stackable<E> {
    public static final int DEFAULT_CAPACITY = 8;

    private final int capacity;
    private final E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.capacity = DEFAULT_CAPACITY;
        data = (E[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Cannot initialize object with specified negative capacity value");
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top + 1 == capacity;
    }

    @Override
    public E push(E item) throws FullStackException {
        if (isFull()) {
            throw new FullStackException("Cannot push item into full stack");
        }
        data[++top] = item;
        return data[top];
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot pop item from empty stack");
        }
        return data[top--];
    }

    @Override
    public Optional<E> popIfPresent() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(data[top--]);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Cannot peek item from empty stack");
        }
        return data[top];
    }

    public int size() {
        return top + 1;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size()));
    }
}
