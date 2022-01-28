package project20280.list;

import org.junit.jupiter.api.Test;
import project20280.interfaces.List;

import static org.junit.Assert.assertEquals;

class SinglyLinkedListTest {

	@Test
	void testIsEmpty() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		assertEquals(true, ll.isEmpty());
		
		ll.addLast(1);
		assertEquals(false, ll.isEmpty());

		ll.removeLast();
		assertEquals(true, ll.isEmpty());
	}

	@Test
	void testGet() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		
		Integer r = ll.get(2);
		assertEquals(3, r, "did not get right element" + r);
	}

	@Test
	void testAdd() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		
		ll.add(1, 100);
		
		assertEquals("[1, 100, 2, 3]", ll.toString(), "item not added correctly");
	}

	@Test
	void testRemove() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);

		assertEquals(3, ll.remove(2), "the removed value should be 3");
		assertEquals(2, ll.size(), "the size should be 2");
	}

	@Test
	void testSize() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		assertEquals(0, ll.size());
		
		ll.addFirst(1);
		assertEquals(1, ll.size());
		
		ll.removeFirst();
		assertEquals(0, ll.size());
	}

	@Test
	void testRemoveFirst() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
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
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		assertEquals(3, ll.removeLast());
		assertEquals(2, ll.size());
	}

	@Test
	void testAddFirst() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addLast(-1);
		ll.addFirst(1);

		assertEquals(2, ll.size());
		assertEquals("[1, -1]", ll.toString());
	}

	@Test
	void testAddLast() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addFirst(1);
		ll.addLast(-1);

		assertEquals(2, ll.size());
		assertEquals("[1, -1]", ll.toString());
	}

	@Test
	void testToString() {
		List<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		assertEquals("[1, 2, 3]", ll.toString());
	}

}
