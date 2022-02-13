package project20280.stacksqueues;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project20280.interfaces.List;
import project20280.interfaces.Stack;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayStackTest {
    @Test
    void testSize() {
        Stack<Integer> s = new ArrayStack<>();

        assertEquals(0, s.size());

        int N = 16;
        for(int i = 0; i < N; ++i) s.push(i);
        assertEquals(N, s.size());
    }

    @Test
    void testIsEmpty() {
        Stack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 10; ++i)
            s.push(i);
        for(int i = 0; i < 10; ++i) {
            s.pop();
        }
        assertEquals(true, s.isEmpty());
    }

    @Test
    void testPush() {
        Stack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals(10, s.size());
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
    }

    @Test
    void testTop() {
        Stack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals(9, Optional.ofNullable(s.top()));
    }

    @Test
    void testPop() {
        Stack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals(9, Optional.ofNullable(s.pop()));
        assertEquals(9, s.size());
    }

    @Test
    void testToString() {
        Stack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
    }
}
