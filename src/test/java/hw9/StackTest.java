package hw9;

import hw9.stack.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing methods of the Stack class")
class StackTest {
    private MyStack<Integer> stack;

    @Test
    @DisplayName("The constructor should throw an exception when a negative stack capacity is specified")
    void constructor_Should_ThrowException_When_NegativeStackCapacityValueSpecified() {
        int negativeCapacity = -6;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new MyStack<Integer>(negativeCapacity))
                .withMessage("Cannot initialize object with specified negative capacity value");
    }

    @Nested
    @DisplayName("Testing methods of the Stack class with an empty stack")
    class EmptyStackTest {

        @BeforeEach
        void initialize() {
            stack = new MyStack<>();
        }

        @Test
        @DisplayName("The returned boolean value should describe the stack size value being equal to zero")
        void isEmpty_Should_ReturnTrue_When_StackSizeValueEqualsZero() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("The returned boolean value should describe the equality of the stack size value and the stack capacity value")
        void isFull_Should_ReturnFalse_When_StackSizeValueDoesNotEqualStackCapacity() {
            assertFalse(stack.isFull());
        }

        @Test
        @DisplayName("An exception should be thrown when the stack is empty and cannot pop an item")
        void pop_Should_ThrowException_When_StackIsEmpty() {
            assertThatExceptionOfType(IllegalStateException.class)
                    .isThrownBy(stack::pop)
                    .withMessage("Cannot pop item from empty stack");
        }

        @Test
        @DisplayName("An exception should be thrown when the stack is empty and cannot peek the item")
        void peek_Should_ThrowException_When_StackIsEmpty() {
            assertThatExceptionOfType(IllegalStateException.class)
                    .isThrownBy(stack::peek)
                    .withMessage("Cannot peek item from empty stack");
        }

        @Nested
        @DisplayName("Testing methods of the Stack class with not an empty stack")
        class NotEmptyStackTest {
            Integer itemToPush = new Random().nextInt();

            @BeforeEach
            void push() {
                stack.push(itemToPush);
            }

            @Test
            @DisplayName("The pushed item should be added to the top of the stack")
            void push_Should_AddItemOnTop_When_StackIsNotFull() {
                Integer itemToPush = new Random().nextInt();

                Integer pushedItem = stack.push(itemToPush);
                Integer peekedItem = stack.peek();

                assertEquals(peekedItem, pushedItem);
            }

            @Test
            @DisplayName("The popped item should be removed from the top of the stack")
            void pop_Should_DeleteItemFromTop_When_StackIsNotEmpty() {
                Integer peekedItem = stack.peek();
                Integer poppedItem = stack.pop();

                assertEquals(peekedItem, poppedItem);
            }

            @Test
            @DisplayName("The peeked item should be popped from the top of the stack")
            void peek_Should_GetItemFromTop_When_StackIsNotEmpty() {
                Integer peekedItem = stack.peek();

                assertEquals(peekedItem, itemToPush);
            }

            @Test
            @DisplayName("An exception should be thrown when the stack is full and cannot place a new item")
            void push_Should_ThrowException_When_StackIsFull() {
                while (!stack.isFull()) {
                    stack.push(new Random().nextInt());
                }

                assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> stack.push(new Random().nextInt()))
                        .withMessage("Cannot push item into full stack");
            }

            @Test
            @DisplayName("The returned boolean value should describe the stack size value being equal to zero")
            void isEmpty_Should_ReturnFalse_When_StackSizeValueDoesNotEqualZero() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("The returned boolean value should describe the equality of the stack size value and the stack capacity value")
            void isFull_Should_ReturnTrue_When_StackSizeValueEqualsStackCapacity() {
                while (!stack.isFull()) {
                    stack.push(new Random().nextInt());
                }

                assertTrue(stack.isFull());
            }
        }
    }
}