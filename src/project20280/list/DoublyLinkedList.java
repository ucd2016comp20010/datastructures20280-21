package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E> {

	private static class Node<E> {

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the preceding node in the list */
		private Node<E> prev; // reference to the previous node in the list

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param p reference to a node that should precede the new node
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		// public accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that precedes this one (or null if no such node).
		 * 
		 * @return the preceding node
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Update methods
		/**
		 * Sets the node's previous reference to point to Node n.
		 * 
		 * @param p the node that should precede this one
		 */
		public void setPrev(Node<E> p) {
			prev = p;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	/** Sentinel node at the beginning of the list */
	private Node<E> header; // header sentinel

	/** Sentinel node at the end of the list */
	private Node<E> trailer; // trailer sentinel

	/** Number of elements in the list (not including sentinels) */
	private int size = 0; // number of elements in the list

	/** Constructs a new empty list. */
	public DoublyLinkedList() {
		// TODO
	}

	// public accessor methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list.
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		// TODO
		return null;
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		// TODO
		return null;
	}

	// public update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) {
		addBetween(e, header, header.getNext()); // place just after the header
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		// TODO
		return null;
	}

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		// TODO
		return null;
	}

	// private update methods
	/**
	 * Adds an element to the linked list in between the given nodes. The given
	 * predecessor and successor should be neighboring each other prior to the call.
	 *
	 * @param predecessor node just before the location where the new element is
	 *                    inserted
	 * @param successor   node just after the location where the new element is
	 *                    inserted
	 */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// create and link a new node
		// TODO
		return;
	}

	public E get(int i) {
		// TODO
		return null;
	}

	public E remove(int i) {
		// TODO
		return null;
	}

	public void add(int i, E e) {
		// TODO
		return;
	}

	/**
	 * Removes the given node from the list and returns its element.
	 * 
	 * @param node the node to be removed (must not be a sentinel)
	 */
	private E remove(Node<E> node) {
		// TODO
		return null;
	}

	public String toString() {
		// TODO
		return null;
	}

	private class PositionIterator<E> implements Iterator<E> {

		/** A Position of the containing list, initialized to the first position. */
		private Node<E> cursor = (Node<E>) header.next; // position of the next element to report

		private Node<E> recent = null; // position of last reported element

		/**
		 * Tests whether the iterator has a next object.
		 * 
		 * @return true if there are further objects, false otherwise
		 */
		public boolean hasNext() {
			return (cursor != trailer);
		}

		/**
		 * Returns the next position in the iterator.
		 *
		 * @return next position
		 * @throws NoSuchElementException if there are no further elements
		 */
		public E next() throws NoSuchElementException {
			if (cursor == trailer)
				throw new NoSuchElementException("nothing left");
			recent = cursor; // element at this position might later be removed
			cursor = cursor.next;
			return recent.element;
		}

		/**
		 * Removes the element returned by most recent call to next.
		 * 
		 * @throws IllegalStateException if next has not yet been called
		 * @throws IllegalStateException if remove was already called since recent next
		 */
		public void remove() throws IllegalStateException {
		}
	} // ------------ end of nested PositionIterator class ------------

	@Override
	public Iterator<E> iterator() {
		return new PositionIterator<E>();
	}

	public static void main(String[] args) {
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

}
