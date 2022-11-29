package hw9.stack;

public interface Stackable<E> {
    boolean isEmpty();
    boolean isFull();
    E push(E item);
    E pop();
    E peek();
}
