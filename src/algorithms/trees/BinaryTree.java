package algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

import entities.GenericNode;

public class BinaryTree<T> {

	public GenericNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T value) {
		root = new GenericNode<T>(value);
	}

	public GenericNode<T> createTree(T[] nums) {

		GenericNode<T> peek;
		GenericNode<T> temp;
		Queue<GenericNode<T>> q = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			temp = new GenericNode<T>(nums[i]);
			if (root == null) {
				root = temp;
				q.add(temp);
			} else {
				peek = q.peek();
				if (peek.getPrev() == null) {
					peek.setPrev(temp);
					q.add(temp);
				} else {
					peek.setNext(temp);
					q.add(temp);
					q.remove();
				}
			}

		}
		q = null;
		return root;
	}

	public GenericNode<T> buildTreeInLevelOrderTraversal(T[] itemList) {

		Queue<GenericNode<T>> queue = new LinkedList<GenericNode<T>>();
		GenericNode<T> temp;
		GenericNode<T> newNode;
		for (int i = 0; i < itemList.length; i++) {
			newNode = new GenericNode<T>(itemList[i]);
			if (root == null) {
				root = newNode;
				queue.add(root);
			} else {
				temp = queue.peek();
				if (temp.getPrev() == null) {
					temp.setPrev(newNode);
					queue.add(newNode);
				} else if (temp.getNext() == null) {
					temp.setNext(newNode);
					queue.add(newNode);
					queue.remove();
				}
			}

		}
		queue = null;
		return root;
	}

	public void levelOrderTraversal() {

		if (root == null) {
			System.out.println("BinaryTree in empty");
			return;
		}
		System.out.println("LevelOrder Traversal :");
		Queue<GenericNode<T>> queue = new LinkedList<GenericNode<T>>();
		GenericNode<T> temp;
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			temp = queue.peek();
			if (temp != null) {
				if (temp.getPrev() != null) {
					queue.add(temp.getPrev());
				}
				if (temp.getNext() != null) {
					queue.add(temp.getNext());
				}
				System.out.print(queue.remove().getValue() + " - ");
			} else {
				queue.remove();
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}
	}

	public void preOrderTraversal() {

		if (root == null) {
			System.out.println("BinaryTree is empty ");
		}
		System.out.println("PreOrder Traversal :");
		preOrderTraversalRecur(root);
		System.out.println();

	}

	public void preOrderTraversalRecur(GenericNode<T> node) {

		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + "->");
		preOrderTraversalRecur(node.getPrev());
		preOrderTraversalRecur(node.getNext());
	}

	public void postOrderTraversal() {

		if (root == null) {
			System.out.println("BinaryTree is empty ");
		}
		System.out.println("PostOrder Traversal :");
		postOrderTraversalRecur(root);
		System.out.println();

	}

	public void postOrderTraversalRecur(GenericNode<T> node) {

		if (node == null) {
			return;
		}
		postOrderTraversalRecur(node.getPrev());
		postOrderTraversalRecur(node.getNext());
		System.out.print(node.getValue() + "->");
	}

	public void inOrderTraversal() {

		if (root == null) {
			System.out.println("BinaryTree is empty ");
		}
		System.out.println("InOrder Traversal :");
		inOrderTraversalRecur(root);
		System.out.println();

	}

	public void inOrderTraversalRecur(GenericNode<T> node) {

		if (node == null) {
			return;
		}
		inOrderTraversalRecur(node.getPrev());
		System.out.print(node.getValue() + "->");
		inOrderTraversalRecur(node.getNext());

	}

	public void insertElement(T element) {

		GenericNode<T> newNode = new GenericNode<T>(element);
		if (root == null) {
			root = newNode;
		} else {
			Queue<GenericNode<T>> queue = new LinkedList<GenericNode<T>>();
			queue.add(root);
			GenericNode<T> temp;
			while (!queue.isEmpty()) {
				temp = queue.peek();
				if (temp.getPrev() != null) {
					queue.add(temp.getPrev());
				} else {
					temp.setPrev(newNode);
					break;
				}
				if (temp.getNext() != null) {
					queue.add(temp.getNext());
				} else {
					temp.setNext(newNode);
					break;
				}
				queue.remove();
			}

		}

	}

}
