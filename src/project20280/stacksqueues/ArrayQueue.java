package project20280.stacksqueues;

import project20280.interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {

	private static int CAPACITY = 1000;
	private E[] data;
	private int front = 0;
	private int size = 0;

	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public ArrayQueue() {
		this(CAPACITY);
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
	public void enqueue(E e) {
		if(size == data.length) {
			return;
		}
		int pos = (front + size) % CAPACITY;
		data[pos] = e;
		size++;
	}

	@Override
	public E first() {
		return isEmpty() ? null : data[front];
	}

	@Override
	public E dequeue() {
		if(isEmpty()) return null;
		E res = data[front];
		data[front] = null;
		front = (front + 1) % CAPACITY;
		size--;
		return res;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size; ++i) {
			E res = data[(front + i) % CAPACITY];
			sb.append(res);
			if(i != size-1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		Queue<Integer> qq = new ArrayQueue<>();
		System.out.println(qq);

		int N = 10;
		for(int i = 0; i < N; ++i) {
			qq.enqueue(i);
		}
		System.out.println(qq);

		for(int i = 0; i < N/2; ++i) qq.dequeue();
		System.out.println(qq);

	}
}
