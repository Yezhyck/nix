package hw12;

import hw12.stack.MyStack;
import hw12.stack.exception.EmptyStackException;
import hw12.stack.exception.FullStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing methods of the Stack class")
class StackExceptionsTest {
    private MyStack<Integer> stack;

    @Nested
    @DisplayName("Testing methods of the Stack class with an empty stack")
    class EmptyStackTest {

        @BeforeEach
        void initialize() {
            stack = new MyStack<>();
        }

        @Test
        @DisplayName("An exception should be thrown when the stack is empty and cannot pop an item")
        void pop_Should_ThrowException_When_StackIsEmpty() {
            assertThatExceptionOfType(EmptyStackException.class)
                    .isThrownBy(stack::pop)
                    .withMessage("Cannot pop item from empty stack");
        }

        @Test
        @DisplayName("An exception should be thrown when the stack is empty and cannot pop an item")
        void popIfPresent_Should_ReturnOptionalEmpty_When_StackIsEmpty() {
            Optional<Integer> emptyOptionalItem = stack.popIfPresent();

            Integer expectedItem = -1;
            Integer actualItem = emptyOptionalItem.orElse(expectedItem);

            assertTrue(emptyOptionalItem.isEmpty());
            assertEquals(expectedItem, actualItem);
        }

        @Test
        @DisplayName("An exception should be thrown when the stack is empty and cannot peek the item")
        void peek_Should_ThrowException_When_StackIsEmpty() {
            assertThatExceptionOfType(EmptyStackException.class)
                    .isThrownBy(stack::peek)
                    .withMessage("Cannot peek item from empty stack");
        }

        @Nested
        @DisplayName("Testing methods of the Stack class with not an empty stack")
        class NotEmptyStackTest {
            Integer itemToPush = new Random().nextInt();

            @BeforeEach
            void push() throws FullStackException {
                stack.push(itemToPush);
            }

            @Test
            @DisplayName("The popped item should be removed from the top of the stack")
            void popIfPresent_Should_ReturnOptionalPresent_When_StackIsNotEmpty() {
                Optional<Integer> emptyOptionalItem = stack.popIfPresent();

                Integer nonExpectedItem = -1;
                Integer actualItem = emptyOptionalItem.orElse(nonExpectedItem);

                assertTrue(emptyOptionalItem.isPresent());
                assertEquals(itemToPush, actualItem);
            }

            @Test
            @DisplayName("An exception should be thrown when the stack is full and cannot place a new item")
            void push_Should_ThrowException_When_StackIsFull() throws FullStackException {
                while (!stack.isFull()) {
                    stack.push(new Random().nextInt());
                }

                assertThatExceptionOfType(FullStackException.class)
                        .isThrownBy(() -> stack.push(new Random().nextInt()))
                        .withMessage("Cannot push item into full stack");
            }
        }
    }
}
