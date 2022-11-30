package hw12;

import hw12.stack.MyStack;
import hw12.stack.exception.EmptyStackException;
import hw12.stack.exception.FullStackException;

public class StackExceptionsRunner {

    public static void main(String[] args) {
        MyStack<Integer> defaultCapacityMyStack = new MyStack<>();
        MyStack<Integer> specifiedCapacityMyStack = new MyStack<>(12);

        runIntegerStack(defaultCapacityMyStack);
        runIntegerStack(specifiedCapacityMyStack);
    }

    public static void runIntegerStack(MyStack<Integer> stack) {
        System.out.printf("Optional item popped by \"popIfPresent()\" method from empty stack(with capacity: %s) : %s.%n%n", stack.capacity(), stack.popIfPresent());

        try {
            for (int i = 0; !stack.isFull(); i++) {
                System.out.printf("Item pushed into stack(with capacity: %s): %s.%n", stack.capacity(), stack.push(i));
            }
        } catch (FullStackException e) {
            e.printStackTrace();
        }

        System.out.printf("State of stack(with capacity: %s): %s.%n%n", stack.capacity(), stack);

        System.out.printf("Optional item popped by \"popIfPresent()\" method from full stack(with capacity: %s) : %s.%n%n", stack.capacity(), stack.popIfPresent());

        try {
            while (!stack.isEmpty()) {
                System.out.printf("Item popped from stack(with capacity: %s): %s.%n", stack.capacity(), stack.pop());
            }
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

        System.out.printf("State of stack(with capacity: %s): %s.%n%n", stack.capacity(), stack);
    }
}
