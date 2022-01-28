package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;


public class SinglyLinkedList<E> implements List<E> {

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

	private Node<E> head = null;
	private int size = 0;

	public SinglyLinkedList() {

	}

	@Override
	public boolean isEmpty() {
		// TODO
		return false;
	}


	@Override
	public E get(int i) {
		// TODO
		return null;
	}

	/**
	 * Inserts the given element at the specified index of the list, starting
	 * from index 0 (head of the list)
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 */
	@Override
	public void add(int i, E e) {
		// TODO
		return;
	}

	@Override
	public E remove(int i) {
		// TODO
		return null;
	}

	private class SinglyLinkedListIterator<E> implements Iterator<E> {
		Node<E> curr = (Node<E>) head;

		@Override
		public boolean hasNext() {
			return curr != null;
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
		return new SinglyLinkedListIterator<E>();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E removeFirst() {
		// TODO
		return null;
	}

	@Override
	public E removeLast() {
		// TODO
		return null;
	}

	@Override
	public void addFirst(E e) {
		// TODO
		return;
	}

	@Override
	public void addLast(E e) {
		// TODO
		return;
	}

	private Node<E> getLast() {
		// TODO
		return null;
	}

	public String toString() {
		// TODO
		return null;
	}

	public static void main1() {
		String[] alphabet = "ABCDEF".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addLast(s);
		}
		System.out.println(sll);

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
		//main1();
		//main2(args);
		main4(args);
	}

	public static void main2(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll);

		sll.removeFirst();
		System.out.println(sll);

		sll.removeLast();
		System.out.println(sll);

		sll.remove(2);
		System.out.println(sll);

		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}

	public static void main4(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		//LinkedList<Integer> ll = new LinkedList<Integer>();

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
		
		int size = ll.size();
		for(int i = 0; i < size; ++i) {
			Integer element = ll.get(i);
		}
		
		for(Integer element: ll) {
			System.out.println(element);
		}
		
		System.out.println("testing remove -> " + ll);
		while(!ll.isEmpty()) {
			Integer r = ll.remove(ll.size()-1);
			System.out.println(r + " -> " + ll);
		}
		
	}
}
