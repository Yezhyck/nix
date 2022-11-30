package hw9;

import hw9.stack.MyStack;

public class StackRunner {

    public static void main(String[] args) {
        MyStack<Integer> defaultCapacityMyStack = new MyStack<>();
        MyStack<Integer> specifiedCapacityMyStack = new MyStack<>(12);

        runIntegerStack(defaultCapacityMyStack);
        runIntegerStack(specifiedCapacityMyStack);
    }

    public static void runIntegerStack(MyStack<Integer> stack) {
        for (int i = 0; !stack.isFull(); i++) {
            System.out.printf("Item pushed into stack(with capacity: %s): %d.%n", stack.capacity(), stack.push(i));
        }

        System.out.printf("State of stack(with capacity: %s): %s.%n%n", stack.capacity(), stack);

        while (!stack.isEmpty()) {
            System.out.printf("Item popped from stack(with capacity: %s): %d.%n", stack.capacity(), stack.pop());
        }

        System.out.printf("State of stack(with capacity: %s): %s.%n%n", stack.capacity(), stack);
    }
}
