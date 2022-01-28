package project20280.tree;

import project20280.interfaces.Position;

import java.util.ArrayList;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	/** Nested static class for a binary tree node. */
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> left, right, parent;

		public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
			element = e;
			left = l;
			right = r;
			parent = p;
		}

		// accessor
		public E getElement() {
			return element;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		}

		public Node<E> getParent() {
			return parent;
		}

		// modifiers
		public void setElement(E e) {
			element = e;
		}

		public void setLeft(Node<E> n) {
			left = n;
		}

		public void setRight(Node<E> n) {
			right = n;
		}

		public void setParent(Node<E> n) {
			parent = n;
		}

		public String toString() {
			// (e)
			StringBuilder sb = new StringBuilder();
			if (element == null) {
				sb.append("\u29B0");
			} else {
				sb.append(element);
			}
			// sb.append(" l:").append(left.element).append(" r:").append(right.element);
			// sb.append();
			return sb.toString();
		}
	}

	/** Factory function to create a new node storing element e. */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}

	// LinkedBinaryTree instance variables
	/** The root of the binary tree */
	protected Node<E> root = null; // root of the tree

	/** The number of nodes in the binary tree */
	private final int size = 0; // number of nodes in the tree

	// constructor
	/** Constructs an empty binary tree. */
	public LinkedBinaryTree() {
	} // constructs an empty binary tree

	// nonpublic utility
	/**
	 * Verifies that a Position belongs to the appropriate class, and is not one
	 * that has been previously removed. Note that our current implementation does
	 * not actually verify that the position belongs to this particular list
	 * instance.
	 *
	 * @param p a Position (that should belong to this tree)
	 * @return the underlying Node instance for the position
	 * @throws IllegalArgumentException if an invalid position is detected
	 */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getParent() == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	// accessor methods (not already implemented in AbstractBinaryTree)
	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return number of nodes in the tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the root Position of the tree (or null if tree is empty).
	 * 
	 * @return root Position of the tree (or null if tree is empty)
	 */
	@Override
	public Position<E> root() {
		return root;
	}

	/**
	 * Returns the Position of p's parent (or null if p is root).
	 *
	 * @param p A valid Position within the tree
	 * @return Position of p's parent (or null if p is root)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO
		return null;
	}

	/**
	 * Returns the Position of p's left child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the left child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		// TODO
		return null;
	}

	/**
	 * Returns the Position of p's right child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the right child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO
		return null;
	}

	// update methods supported by this class
	/**
	 * Places element e at the root of an empty tree and returns its new Position.
	 *
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */
	public Position<E> addRoot(E e) throws IllegalStateException {
		// TODO
		return null;
	}

	public void insert(E e) {
		// TODO
		return;
	}

	// recursively add Nodes to binary tree in proper position
	private Node<E> addRecursive(Node<E> p, E e) {
		// TODO
		return null;
	}

	/**
	 * Creates a new left child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p the Position to the left of which the new element is inserted
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 * @throws IllegalArgumentException if p already has a left child
	 */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		// TODO
		return null;
	}

	/**
	 * Creates a new right child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p the Position to the right of which the new element is inserted
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 * @throws IllegalArgumentException if p already has a right child
	 */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		// TODO
		return null;
	}

	/**
	 * Replaces the element at Position p with element e and returns the replaced
	 * element.
	 *
	 * @param p the relevant Position
	 * @param e the new element
	 * @return the replaced element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		// TODO
		return null;
	}

	/**
	 * Attaches trees t1 and t2, respectively, as the left and right subtree of the
	 * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 an independent tree whose structure becomes the left child of p
	 * @param t2 an independent tree whose structure becomes the right child of p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 * @throws IllegalArgumentException if p is not a leaf
	 */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		// TODO
	}

	/**
	 * Removes the node at Position p and replaces it with its child, if any.
	 *
	 * @param p the relevant Position
	 * @return element that was removed
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 * @throws IllegalArgumentException if p has two children.
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {
		// TODO
		return null;
	}

	public String toString() {
		// TODO
		return null;
	}

	public void createLevelOrder(ArrayList<E> l) {
		root = createLevelOrderHelper(l, root, 0);
	}

	private Node<E> createLevelOrderHelper(ArrayList<E> l, Node<E> p, int i) {
		// TODO
		return null;
	}

	public void createLevelOrder(E[] arr) {
		root = createLevelOrderHelper(arr, root, 0);
	}

	private Node<E> createLevelOrderHelper(E[] arr, Node<E> p, int i) {
		// TODO
		return null;
	}

	public String toBinaryTreeString() {
		BinaryTreePrinter<E> btp = new BinaryTreePrinter<>(this);
		return btp.print();
	}

	public static LinkedBinaryTree<Integer> makeRandom(int n) {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.root = randomTree(null, 1, n);
		return bt;
	}

	static java.util.Random rnd = new java.util.Random();

	public static <T extends Integer> Node<T> randomTree(Node<T> parent, Integer first, Integer last) {
		if (first > last)
			return null;
		else {
			Integer treeSize = last - first + 1;
			Integer leftCount = rnd.nextInt(treeSize);
			Integer rightCount = treeSize - leftCount - 1;
			Node<T> root = new Node<T>((T) ((Integer)(first + leftCount)), parent, null, null);
			root.setLeft(randomTree(root, first, first + leftCount - 1));
			root.setRight(randomTree(root, first + leftCount + 1, last));
			return root;
		}
	}



	

	public static void main(String[] args) {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

		/*
		 * // Direct construction of Tree Position<Integer> root = bt.addRoot(12);
		 * Position<Integer> p1 = bt.addLeft(root, 25); Position<Integer> p2 =
		 * bt.addRight(root, 31);
		 * 
		 * Position<Integer> p3 = bt.addLeft(p1, 58); bt.addRight(p1, 36);
		 * 
		 * Position<Integer> p5 = bt.addLeft(p2, 42); bt.addRight(p2, 90);
		 * 
		 * Position<Integer> p4 = bt.addLeft(p3, 62); bt.addRight(p3, 75);
		 */
		// Level order construction
		Integer[] arr = { 12, 25, 31, 58, 36, 42, 90, 62, 75 };
		bt.createLevelOrder(arr);

		System.out.println("bt inorder: " + bt.size() + " " + bt.inorder());
		System.out.println("bt preorder: " + bt.size() + " " + bt.preorder());
		System.out.println("bt preorder: " + bt.size() + " " + bt.postorder());

		System.out.println("bt height: " + bt.height(bt.root()));
		System.out.println("bt depth: " + bt.depth(bt.root()));

		System.out.println(bt.toBinaryTreeString());
//		System.out.println("bt depth 62: " + bt.depth(p4));
//		System.out.println("bt depth 45: " + bt.depth(p5));

//	  int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
//	  for(int i : arr) {
//		  bt.insert(i);
//	  }
//	  
	}
}
