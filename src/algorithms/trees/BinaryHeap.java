package algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

import entities.GenericNode;

/*
 * Max Heap : Value of Parent Node > Value of any of its child nodes
 * Min Heap : Value of Parent Node < Value of any of its child nodes
 * 
 * Binary Heap :
 * 1. Is a BinaryTree
 * 2. Follows the Heap Property
 * 3. Is a complete tree  
 * 
 * Complete tree : constructed using level order traversal left to right
 * 
 * 
 * HEAP SORT  : 
 * 1. Build a heap 
 * - O(nlogn) - optimization
 * n elements, logn shiftUps for every element
 * 2. Call extract min, n times
 * - call swift down takes logn time
 * - O(nlogn)
 * 
 * 
 *  
 * 
 */
public class BinaryHeap {
	// code in BinarySearchTree Class

	public GenericNode<Integer> root;
	public int size;
	public GenericNode<Integer> lastNode;

	public BinaryHeap() {
		root = null;
		size = 0;
	}

	public BinaryHeap(Integer value) {
		root = new GenericNode<Integer>(value);
		size = 1;
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

	public void shiftUp(GenericNode<Integer> parentNode, GenericNode<Integer> childNode) {

		while (parentNode != null && parentNode.getValue() > childNode.getValue()) {
			int temp = childNode.getValue();
			childNode.setValue(parentNode.getValue());
			parentNode.setValue(temp);
			childNode = parentNode;
			parentNode = parentNode.getParent();

		}

	}

	public void shiftDown(GenericNode<Integer> node) {

		if (node == null) {
			return;
		} else {

			GenericNode<Integer> leftChild = node.getPrev();
			GenericNode<Integer> rightChild = node.getNext();

			if (leftChild == null && rightChild == null) {
				return;
			} else if (leftChild != null && rightChild == null) {

				if (leftChild.getValue() > node.getValue()) {
					return;
				} else {
					int temp = node.getValue();
					node.setValue(leftChild.getValue());
					leftChild.setValue(temp);
					shiftDown(leftChild);
				}

			} else if (rightChild != null && leftChild == null) {

				if (rightChild.getValue() > node.getValue()) {
					return;
				} else {
					int temp = node.getValue();
					node.setValue(rightChild.getValue());
					rightChild.setValue(temp);
					shiftDown(rightChild);
				}

			} else {
				int leftVal = leftChild.getValue();
				int rightVal = rightChild.getValue();

				if (node.getValue() < leftVal && node.getValue() < rightVal) {
					return;
				} else if (leftVal < rightVal) {
					int temp = node.getValue();
					node.setValue(leftChild.getValue());
					leftChild.setValue(temp);
					shiftDown(leftChild);
				} else {
					int temp = node.getValue();
					node.setValue(rightChild.getValue());
					rightChild.setValue(temp);
					shiftDown(rightChild);
				}

			}

		}

	}

	public GenericNode<Integer> buildMinHeap(Integer[] itemList) {

		Queue<GenericNode<Integer>> queue = new LinkedList<GenericNode<Integer>>();
		GenericNode<Integer> temp;
		GenericNode<Integer> newNode;
		for (int i = 0; i < itemList.length; i++) {
			newNode = new GenericNode<Integer>(itemList[i]);
			size++;
			if (root == null) {
				root = newNode;
				queue.add(root);
			} else {
				temp = queue.peek();
				if (temp.getPrev() == null) {
					newNode.setParent(temp);
					temp.setPrev(newNode);
					queue.add(newNode);
				} else if (temp.getNext() == null) {
					newNode.setParent(temp);
					temp.setNext(newNode);
					queue.add(newNode);
					queue.remove();
				}
				lastNode = newNode;
				shiftUp(temp, newNode);

			}

		}
		queue = null;
		return root;
	}

	// below code works because of complete tree property
	public Integer[] extactMinAndSort() {

		Integer[] sortedList = new Integer[size];
		int i = 0;
		if (root == null) {
			System.out.println("Binary Heap is mepty");
		} else {
			while (root != null) {
				GenericNode<Integer> temp = root;
				
				int min = temp.getValue();
				sortedList[i++] = min;
				if l

				shiftDown(root);
			}
		}

		return sortedList;

	}

}
