package project20280.list;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import project20280.interfaces.List;

import java.util.stream.IntStream;

//import static org.junit.Assert.assertEquals;

class CircularlyLinkedListTest {

	@Test
	void testIsEmpty() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		assertEquals(true, ll.isEmpty());
		
		ll.addLast(1);
		assertEquals(false, ll.isEmpty());

		ll.removeLast();
		assertEquals(true, ll.isEmpty());
	}

	@Test
	void testGet() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		assertEquals("[1, 2, 3]", ll.toString());
		assertEquals(1, ll.get(0), "did not get right element(0)");
		assertEquals(2, ll.get(1), "did not get right element(1)");
		assertEquals(3, ll.get(2), "did not get right element(2)");
	}

	@Test
	void testAdd() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		
		ll.add(1, 100);
		
		assertEquals("[1, 100, 2, 3]", ll.toString(), "item not added correctly");
	}

	@Test
	void testRemove() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);

		assertEquals(2, ll.remove(1), "the removed value should be 1 ");
		assertEquals(2, ll.size(), "the size should be 2");
	}

	@Test
	void testSize() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		assertEquals(0, ll.size());
		
		ll.addFirst(1);
		assertEquals(1, ll.size());
		
		ll.removeFirst();
		assertEquals(0, ll.size());
	}

	@Test
	void testRemoveFirst() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		assertEquals(null, ll.removeFirst());
		
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		Integer r = ll.removeFirst();
		assertEquals(1, r);
		assertEquals(2, ll.size());
	}

	@Test
	void testRemoveLast() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		assertEquals(3, ll.removeLast());
		assertEquals(2, ll.size());
	}

	@Test
	void testAddFirst() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(-1);
		ll.addFirst(1);

		assertEquals(2, ll.size());
		assertEquals("[1, -1]", ll.toString());
	}

	@Test
	void testAddLast() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addFirst(1);
		ll.addLast(-1);

		assertEquals(2, ll.size());
		assertEquals("[1, -1]", ll.toString());
	}

	@Test
	void testRotate() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		IntStream.rangeClosed(0, 10).forEach((x) -> ll.addLast(x));
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", ll.toString());

		ll.rotate();
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0]", ll.toString());

	}

	@Test
	void testToString() {
		List<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		assertEquals("[1, 2, 3]", ll.toString());
	}
}
