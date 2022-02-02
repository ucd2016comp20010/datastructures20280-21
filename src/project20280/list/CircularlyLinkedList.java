package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T e, Node<T> n) {
			data = e;
			next = n;
		}

		public T getData() {
			return data;
		}

		public void setNext(Node<T> n) {
			next = n;
		}

		public Node<T> getNext() {
			return next;
		}
	}

	private Node<E> tail = null;
	private int size = 0;

	public CircularlyLinkedList() {

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
		
		Node<E> curr = tail.next;
		for (int j = 0; j < i ; ++j, curr = curr.next)
			;
		return curr.getData();
	}

	/**
	 * Inserts the given element at the specified index of the list, shifting all
	 * subsequent elements in the list one position further to make room.
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 */
	@Override
	public void add(int i, E e) {
		if (i > size) {
			return;
		}
		if (i == 0) {
			addFirst(e);
			return;
		}

		Node<E> curr = tail;
		for (int j = 0; j < i && curr.next != null; ++j, curr = curr.next)
			;
		curr.next = new Node<E>(e, curr.next);
		++size;
	}

	@Override
	public E remove(int i) {
		if (i < 0 || i > size) {
			return null;
		}
		if (i == 0) {
			return removeFirst();
		} else {
//			Node<E> curr = tail;
//			for (int j = 0; j < i - 1; j++) {
//				curr = curr.next;
//			}
//			E res = curr.data;
//			curr.next = curr.next.next;
//			size--;
//			return res;
			
			Node<E> curr = tail.next;
			for (int j = 0; j < i ; j++) {
				curr = curr.next;
			}
			E res = curr.data;
			curr.next = curr.next.next;
			size--;
			return res;

		}
	}

	public void rotate() {
		if(tail != null) {
			tail = tail.next;
		}
	}
	
	private class CircularlyLinkedListIterator<E> implements Iterator<E> {
		Node<E> curr = (Node<E>) tail;

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
		return new CircularlyLinkedListIterator<E>();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		Node<E> head = tail.next;
		if(head == tail) {
			tail = null;
		} else {
			tail.next = head.next;
		}
		--size;
		return head.data;
	}

	@Override
	public E removeLast() {
		if (size <= 1) {
			return removeFirst();
		}

		Node<E> curr = tail;
		while (curr.next != tail) {
			curr = curr.next;
		}
		E res = tail.data;
		curr.next = tail.next;
		tail = curr;
		--size;
		return res;
	}

	@Override
	public void addFirst(E e) {
		if(size == 0) {
			tail = new Node<E>(e, null);
			tail.next = tail;
		} else {
			Node<E> n = new Node<E>(e, tail.next);
			tail.next = n;
		}
		++size;
	}

	@Override
	public void addLast(E e) {
		addFirst(e);
		tail = tail.next;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> curr = tail;
		do {
			curr = curr.next;
			sb.append(curr.data);
			if (curr != tail) {
				sb.append(", ");
			}
		} while(curr != tail);
		sb.append("]");
		return sb.toString();
	}

	public static void main1() {
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
	

	
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();
		System.out.println(ll);

		ll.rotate();
		System.out.println(ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println(ll);

		ll.removeLast();
		ll.rotate();
		System.out.println(ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}

	}
}
