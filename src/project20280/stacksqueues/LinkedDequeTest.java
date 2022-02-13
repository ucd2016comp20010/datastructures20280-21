package project20280.stacksqueues;

import org.junit.jupiter.api.Test;
import project20280.interfaces.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedDequeTest {

    @Test
    void testSize() {
        Deque<Integer> s = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            s.addFirst(i);
        assertEquals(10, s.size());
    }

    @Test
    void testIsEmpty() {
        Deque<Integer> s = new LinkedDeque<>();

        for(int i = 0; i < 10; ++i)
            s.addFirst(i);
        for(int i = 0; i < 10; ++i)
            s.removeFirst();
        assertEquals(true, s.isEmpty());
    }

    @Test
    void testAddFirst() {
        Deque<Integer> s = new LinkedDeque<>();

        for(int i = 0; i < 10; ++i)
            s.addFirst(i);
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
    }

    @Test
    void testAddLast() {
        Deque<Integer> s = new LinkedDeque<>();

        for(int i = 0; i < 10; ++i)
            s.addLast(i);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", s.toString());
    }
    @Test
    void testRemoveFirst() {
        Deque<Integer> s = new LinkedDeque<>();

        for(int i = 0; i < 10; ++i)
            s.addFirst(i);
        s.removeFirst();
        assertEquals("[8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
    }

    @Test
    void testRemoveLast() {
        Deque<Integer> s = new LinkedDeque<>();

        for(int i = 0; i < 10; ++i)
            s.addFirst(i);
        s.removeLast();
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1]", s.toString());
    }
}
