package trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<E extends Comparable<E>> {
	private TreeNode<E> root;
	
	public MyBinarySearchTree() {
		super();
		this.root = null;
	}
	
	public static void main(String[] args) {
		var tree = new MyBinarySearchTree<Integer>();
		System.out.println(tree.toList());
		tree.add(1);
		System.out.println(tree.toList());
		tree.add(3);
		tree.add(2);
		System.out.println(tree.toList());
	}
	
	public void add(E e) {
		this.root = add(e, this.root);
	}
	
	private TreeNode<E> add(E e, TreeNode<E> treeNode) {
		if(treeNode == null) {
			treeNode = new TreeNode<>(e);
		} else if (e.compareTo(treeNode.data) == 0) {
			return treeNode;
		} else if(e.compareTo(treeNode.data) < 0) {
			treeNode.left = add(e, treeNode.left);
		} else {
			treeNode.right = add(e, treeNode.right);
		}
		return treeNode;
	}
	
	public List<E> toList() {
		List<E> list = new ArrayList<>();
		toList(list, this.root);
		return list;
	}
	
	private void toList(List<E> list, TreeNode<E> treeNode) {
		if(treeNode == null)
			return;
		toList(list, treeNode.left);
		list.add(treeNode.data);
		toList(list, treeNode.right);
	}

	private static class TreeNode<E> {
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;
		
		private TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		private TreeNode(E data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + "]";
		}
		
		
	}
}
