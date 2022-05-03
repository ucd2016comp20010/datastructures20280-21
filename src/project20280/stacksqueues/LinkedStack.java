package project20280.stacksqueues;

import project20280.interfaces.Stack;
import project20280.list.DoublyLinkedList;
import project20280.list.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

	DoublyLinkedList<E> ll;
	public static void main(String[] args) {
	}

	public LinkedStack() {
		ll = new DoublyLinkedList<>();
	}

	@Override
	public int size() {
		return ll.size();
	}

	@Override
	public boolean isEmpty() {
		return ll.isEmpty();
	}

	@Override
	public void push(E e) {
		ll.addFirst(e);
	}

	@Override
	public E top() {
		return ll.first();
	}

	@Override
	public E pop() {
		return ll.removeFirst();
	}

	public String toString() {
		return ll.toString();
	}
}
