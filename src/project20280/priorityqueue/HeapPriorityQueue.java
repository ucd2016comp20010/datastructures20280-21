package project20280.priorityqueue;

/*
 */

import project20280.interfaces.Entry;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * An implementation of a priority queue using an array-based heap.
 */

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
	/**
	 * Creates an empty priority queue based on the natural ordering of its keys.
	 */
	public HeapPriorityQueue() {
		super();
	}

	/**
	 * Creates an empty priority queue using the given comparator to order keys.
	 * 
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	/**
	 * Creates a priority queue initialized with the respective key-value pairs. The
	 * two arrays given will be paired element-by-element. They are presumed to have
	 * the same length. (If not, entries will be created only up to the length of
	 * the shorter of the arrays)
	 * 
	 * @param keys   an array of the initial keys for the priority queue
	 * @param values an array of the initial values for the priority queue
	 */
	public HeapPriorityQueue(K[] keys, V[] values) {
		super();
		for(int i = 0; i < keys.length; ++i) {
			heap.add(new PQEntry<>(keys[i], values[i]));
		}
		heapify();
	}

	// protected utilities
	protected int parent(int j) {
		return (j-1)/2;
	}

	protected int left(int j) {
		return 2*j + 1;
	}

	protected int right(int j) {
		return 2*j + 2;
	}

	protected boolean hasLeft(int j) {
	    return left(j) < heap.size();
	}

	protected boolean hasRight(int j) {
		return right(j) < heap.size();

	}

	/** Exchanges the entries at indices i and j of the array list. */
	protected void swap(int i, int j) {
		Entry<K, V> tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
		return;
	}

	/**
	 * Moves the entry at index j higher, if necessary, to restore the heap
	 * property.
	 */
	protected void upheap(int j) {
		// keep doing until satisfied
		// get the parent of j
		// compare keys of current position j with parent(j)
		// if heap order satisfied -> done
		// else bubble up
		while(j > 0) {
			int p = parent(j);
			if( compare(heap.get(j), heap.get(p)) >= 0) {
				break;
			}
			swap(j, p);
			j = p;
		}
	}

	/**
	 * Moves the entry at index j lower, if necessary, to restore the heap property.
	 */
	protected void downheap(int j) {
		// while not at the bottom tree (leaf)
		// if key_parent >= key_child stop
		// find smallest child and swap
		while(left(j) < heap.size()) {
			int left = left(j);
			int right = right(j);
			// figure which child to swap with
			int child = left;
			Entry<K, V> e_left = heap.get(left);
			Entry<K, V> e_child = e_left;
			Entry<K, V> e_j = heap.get(j);

			if(right < heap.size() && compare(e_left, heap.get(right)) > 0) {
				child = right;
			}
			if(compare(heap.get(child), e_j) >= 0) {
				// order restored
				break;
			}
			swap(j, child);
			j = child;
		}
	}

	/** Performs a bottom-up construction of the heap in linear time. */
	protected void heapify() {
		for(int i = parent(size() - 1); i >= 0; --i) {
			downheap(i);
		}
	}

	// public methods

	/**
	 * Returns the number of items in the priority queue.
	 * 
	 * @return number of items
	 */
	@Override
	public int size() {
		return heap.size();
	}

	/**
	 * Returns (but does not remove) an entry with minimal key.
	 * 
	 * @return entry having a minimal key (or null if empty)
	 */
	@Override
	public Entry<K, V> min() {
		return heap.get(0);
	}

	/**
	 * Inserts a key-value pair and return the entry created.
	 * 
	 * @param key   the key of the new entry
	 * @param value the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		PQEntry<K, V> res = new PQEntry<>(key, value);
		heap.add(res);
		upheap(heap.size() - 1);
		return res;
	}

	/**
	 * Removes and returns an entry with minimal key.
	 * 
	 * @return the removed entry (or null if empty)
	 */
	@Override
	public Entry<K, V> removeMin() {
		//
		Entry<K, V> res = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		downheap(0);
		return res;
	}
	
	public String toString() {
		return heap.toString();
	}

	/** Used for debugging purposes only */
	private void sanityCheck() {
		for (int j = 0; j < heap.size(); j++) {
			int left = left(j);
			int right = right(j);
			//System.out.println("-> " +left + ", " + j + ", " + right);
			Entry<K, V> e_left, e_right;
			e_left = left < heap.size() ? heap.get(left) : null;
			e_right = right < heap.size() ? heap.get(right) : null;
			if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0) {
				System.out.println("Invalid left child relationship");
				System.out.println("=> " + e_left + ", " + heap.get(j) + ", " + e_right);
			}
			if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0) {
				System.out.println("Invalid right child relationship");
				System.out.println("=> " + e_left + ", " + heap.get(j) + ", " + e_right);
			}
		}
	}

	/*
	public static < T > String toBinaryTreeString(PriorityQueue<T> pq) {
		LinkedBinaryTree<T> bt = new LinkedBinaryTree<>();
		bt.createLevelOrder(new ArrayList<T>(pq));
		BinaryTreePrinter< T > btp = new BinaryTreePrinter<>(bt);
		return btp.print();
	}
	public static < K,V > String toBinaryTreeString(HeapPriorityQueue<K,V> pq) {
		LinkedBinaryTree< Entry<K, V> > bt = new LinkedBinaryTree<>();
		bt.createLevelOrder(pq.heap);
		BinaryTreePrinter< Entry<K, V> > btp = new BinaryTreePrinter<>(bt);
		return btp.print();
	}
	
	 */

	/*
	public static void main_jdk(String [] args) {
		//HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxComparator());
		//Integer [] rands = new Integer[]{44,17,88,8,32,65,97,28,54,82,93,21,29,76,68,80};
		Integer[] rands = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};
		
		for(Integer i : rands) {
			pq.add(i);
			System.out.println(toBinaryTreeString(pq));
		}
		
		pq.add(34);
		System.out.println(toBinaryTreeString(pq));
	}
		*/


	public static void main_20280(String [] args) {
		HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>(new DefaultComparator());

		//Integer [] rands = new Integer[]{44,17,88,8,32,65,97,28,54,82,93,21,29,76,68,80};
		Integer[] rands = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};
		//Integer[] rands = new Integer[] {1,2,3,4,5,6,7,8};
		
		for(Integer i : rands) {
			pq.insert(i, new String(String.valueOf(i)));
			//System.out.println(toBinaryTreeString(pq));
		}
		System.out.println("after adding elements: " + pq);

		// [1,
		//      2,        5,
		//   23,     4, 12, 15,
		// 35, 24, 33, 21, 26]
		//pq.insert(34, 34);
		//System.out.println(toBinaryTreeString(pq));
		//System.out.println(pq);
		//pq.sanityCheck();
		
		System.out.println("removeMin " + pq.removeMin());
		//System.out.println(toBinaryTreeString(pq));
		System.out.println("after removeMin " + pq);
//		//pq.sanityCheck();
//		while(pq.size()>0) {
//			System.out.println(pq + " -> " + pq.removeMin() + ", " + pq.size());
//		}
		//System.out.println("after removing all elements: " + pq);
	}

	public static void main_heapify(String [] args) {
		Integer[] rands = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};
		HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>(rands, rands);

		System.out.println("elements: " + rands);
		System.out.println("after adding elements: " + pq);

		// [             1,
		//        2,            4,
		//   23,     21,      5, 12,
		// 24, 26, 35, 33, 15]
	}
	public static void main(String[] args) {
		//main_jdk(args);
		//main_20280(args);
		main_heapify(args);
	}
}
