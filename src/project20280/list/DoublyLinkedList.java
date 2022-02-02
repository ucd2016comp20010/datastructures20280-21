package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;
import java.util.LinkedList;

public class DoublyLinkedList<E> implements List<E> {

	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;

		public Node(E e, Node<E> p, Node<E> n) {
			data = e;
			prev = p;
			next = n;
		}

		public E getData() {
			return data;
		}

		public Node<E> getNext() {
			return next;
		}

		public Node<E> getPrev() {
			return prev;
		}

	}

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	public DoublyLinkedList() {
		head = new Node<E>(null, null, null);
		tail = new Node<E>(null, head, null);
		head.next = tail;
	}

	private void addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> n = new Node<E>(e, pred, succ);
		pred.next = n;
		succ.prev = n;
		++size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) {
		if (isEmpty() || i >= size) {
			return null;
		}

		Node<E> curr = head.next;
		for (int j = 0; j < i; ++j) {
			curr = curr.next;
		}

		return curr.data;
	}

	@Override
	public void add(int i, E e) {
		if (i > size) {
			return;
		}
		if (i == 0) {
			addFirst(e);
			return;
		}

		Node<E> curr = head.next;
		for (int j = 0; j < i - 1; j++) {
			curr = curr.next;
		}
		addBetween(e, curr, curr.next);
	}

	@Override
	public E remove(int i) {
		if (i < 0 || i > size) {
			return null;
		}
		if (i == 0) {
			return removeFirst();
		} else {
			Node<E> curr = head.next;
			for (int j = 0; j < i - 1; j++) {
				curr = curr.next;
			}
			E res = curr.data;
			curr.next = curr.next.next;
			size--;
			return res;
		}
	}

	private class DoublyLinkedListIterator<E> implements Iterator<E> {
		Node<E> curr = (Node<E>) head.next;

		@Override
		public boolean hasNext() {
			return curr != tail;
		}

		@Override
		public E next() {
			E res = curr.data;
			curr = curr.next;
			return res;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new DoublyLinkedListIterator<E>();
	}

	private E remove(Node<E> n) {
		Node<E> pred = n.prev;
		Node<E> succ = n.next;
		pred.next = succ;
		succ.prev = pred;
		--size;
		return n.data;
	}

	public E first() {
		if(isEmpty()) { return null;}
		return head.next.getData();
	}

	public E last() {
		if(isEmpty()) { return null; }
		return tail.prev.data;
	}
	
	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return remove(head.next);
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		return remove(tail.prev);
	}

	@Override
	public void addLast(E e) {
		addBetween(e, tail.prev, tail);
	}

	@Override
	public void addFirst(E e) {
		addBetween(e, head, head.next);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> curr = head.next;
		while (curr != tail) {
			sb.append(curr.data);
			curr = curr.next;
			if (curr != tail) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		// main1(args);
		// main2(args);
		main4(args);
	}

	public static void main1(String[] args) {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addLast(-1);
		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();
		System.out.println(ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}
	}

	public static void main2(String[] args) {
		// String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		String[] alphabet = "ABCDEFGHIJ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());

		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());

		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}

	public static void main3(String[] args) {
		String[] alphabet = "ABCDEF".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addLast(s);
		}
		System.out.println(sll.toString());

//		while(!sll.isEmpty()) {
//			//sll.removeLast();
//			System.out.println("first, last " + sll.get(0) + ", " + sll.get(sll.size()-1));
//			sll.removeFirst();
//			System.out.println(sll);
//		}

		for (int i = 0; i < 5; ++i) {
			sll.add(i, "X");
			System.out.println("first, last " + sll.get(0) + ", " + sll.get(sll.size() - 1));
			// sll.removeFirst();
			System.out.println(sll);
		}
	}

	public static void main4(String[] args) {
		//DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.add(3, 2);
		System.out.println(ll);

		ll.addFirst(-100);
		ll.addLast(+100);
		System.out.println(ll);

		ll.removeFirst();
		ll.removeLast();
		System.out.println(ll);

		// Removes the item in the specified index
		ll.remove(2);
		System.out.println(ll);

		// Removes the first occurrence of the specified object
		// ll.remove(new Integer(1));
		// System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();
		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.addFirst(9999);
		ll.addFirst(8888);
		ll.addFirst(7777);
		System.out.println(ll);
		System.out.println(ll.get(0));
		System.out.println(ll.get(1));
		System.out.println(ll.get(2));

		// list.clear();
		System.out.println(ll);
	}

}

/*
 * (5, 4, 3, 2, 1, 0) (-100, 5, 4, 3, 2, 1, 0, 100) (-100, 5, 4, 3, 2, 1, 0,
 * 100) (5, 4, 3, 2, 1, 0) (5, 4, 3, 2, 1, 0) (4, 3, 2, 1, 0) (4, 3, 2, 1) (3,
 * 2, 1) (7777, 8888, 9999, 3, 2, 1) 7777 1 1 (7777, 8888, 9999, 3, 2, 1)
 * 
 */
/*
 * [5, 4, 3, 2, 1, 0] [-100, 5, 4, 3, 2, 1, 0, 100] [-100, 5, 4, 3, 2, 1, 0,
 * 100] [5, 4, 3, 2, 1, 0] [5, 4, 2, 1, 0] [4, 2, 1, 0] [4, 2, 1] [2, 1] [7777,
 * 8888, 9999, 2, 1] 7777 8888 9999 [7777, 8888, 9999, 2, 1]
 */
