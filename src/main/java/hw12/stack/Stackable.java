package hw12.stack;

import hw12.stack.exception.EmptyStackException;
import hw12.stack.exception.FullStackException;

import java.util.Optional;

public interface Stackable<E> {
    boolean isEmpty();

    boolean isFull();

    E push(E item) throws FullStackException;

    E pop() throws EmptyStackException;

    Optional<E> popIfPresent();

    E peek() throws EmptyStackException;
}
