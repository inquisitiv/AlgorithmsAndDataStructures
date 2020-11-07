package algorithms.trees;
/*
 * Node cannot have more than 2 children
 * All value in subtree left are < root value
 * All value in subtree are > root value
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

import entities.GenericNode;

public class BinarySearchTree {

	public GenericNode<Integer> root;

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(Integer value) {
		root = new GenericNode<Integer>(value);
	}

	public GenericNode<Integer> buildTreeInLevelOrderTraversal(Integer[] itemList) {

		Queue<GenericNode<Integer>> queue = new LinkedList<GenericNode<Integer>>();
		GenericNode<Integer> temp;
		GenericNode<Integer> newNode;
		for (int i = 0; i < itemList.length; i++) {
			newNode = new GenericNode<Integer>(itemList[i]);
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
		Queue<GenericNode<Integer>> queue = new LinkedList<GenericNode<Integer>>();
		GenericNode<Integer> temp;
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
				GenericNode<Integer> temp1 = queue.remove();
				System.out.print(temp1.getValue() + "(" + temp1.getHeight() + ")" + " - ");
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

	public void preOrderTraversalRecur(GenericNode<Integer> node) {

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

	public void postOrderTraversalRecur(GenericNode<Integer> node) {

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

	public void inOrderTraversalRecur(GenericNode<Integer> node) {

		if (node == null) {
			return;
		}
		inOrderTraversalRecur(node.getPrev());
		System.out.print(node.getValue() + "->");
		inOrderTraversalRecur(node.getNext());

	}

	public void insertElement(Integer element) {

		GenericNode<Integer> newNode = new GenericNode<Integer>(element);
		if (root == null) {
			root = newNode;
		} else {
			Queue<GenericNode<Integer>> queue = new LinkedList<GenericNode<Integer>>();
			queue.add(root);
			GenericNode<Integer> temp;
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

	public void buildBinarySearchTree(Integer[] itemList) {

		GenericNode<Integer> temp = null;
		GenericNode<Integer> parent = null;
		boolean bigger = false;
		for (int i = 0; i < itemList.length; i++) {

			GenericNode<Integer> newNode = new GenericNode<Integer>(itemList[i]);
			if (root == null) {
				root = newNode;
			} else {
				temp = root;
				parent = null;
				while (temp != null) {
					parent = temp;
					if (newNode.getValue() > temp.getValue()) {
						temp = temp.getNext();
						bigger = true;
					} else {
						temp = temp.getPrev();
						bigger = false;
					}
				}
				if (bigger) {
					parent.setNext(newNode);
				} else {
					parent.setPrev(newNode);
				}

			}

		}

	}

	

}
