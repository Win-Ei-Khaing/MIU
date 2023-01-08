package sortroutines;

import java.util.Arrays;

import runtime.*;

/**
 * This is a BST that handles Integer data. The insert method works only if
 * there are no duplicates.
 */
public class BSTSort extends Sorter {
	int[] arr;
	int[] sorted;
	int i;
	/** The tree root. */
	private Node root;

	// start with an empty tree
	public BSTSort() {
		root = null;
	}
	
	public void sortedInt() {
		traverseTree(root);
	}
	private void traverseTree(Node t) {
		if (t != null) {
			traverseTree(t.left);
			sorted[i++] = (t.element);
			traverseTree(t.right);
		}
	}

	// /////insertion methods
	public void insert(Integer x) {
		if (root == null) {
			root = new Node(x, null, null);
		} else {
			Node n = root;
			boolean inserted = false;
			while (!inserted) {
				if (x.compareTo(n.element) < 0) {
					// space found on the left
					if (n.left == null) {
						n.left = new Node(x, null, null);
						inserted = true;
					} else {
						n = n.left;
					}
				}

				else if (x.compareTo(n.element) > 0) {
					// space found on the right
					if (n.right == null) {
						n.right = new Node(x, null, null);
						inserted = true;
					} else {
						n = n.right;
					}
				} else { 
					inserted = true;
				}

			}

		}
	}

	public static void main(String[] args) {
		BSTSort bst = new BSTSort();
		int[] array = new int[]{2,15,71,95,97,3,75,34,23};
		int[] sortedArr = bst.sort(array);
		System.out.println(Arrays.toString(sortedArr));
	}

	private void populate() {
		for(int a: arr)
			this.insert(a);
	}

	// //////// Node class

	private class Node {

		/////////////// Constructors
		
		@SuppressWarnings("unused")
		Node(Integer theElement) {
			this(theElement, null, null);
		}

		Node(Integer element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

		private Integer element; // The data in the node
		private Node left; // Left child
		private Node right; // Right child
	}

	@Override
	public int[] sort(int[] arr) {
		this.arr = arr;
		sorted = new int[arr.length];
		i = 0;
		populate();
		sortedInt();
		return sorted;
	}
}