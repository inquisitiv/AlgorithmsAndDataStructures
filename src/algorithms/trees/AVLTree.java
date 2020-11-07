package algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

import entities.GenericNode;

/*
 * AVL Tree nothing but self balancing BinarySearchTree
 * 
 * If the tree is balanced, its guaranteed that every insertion takes log(n) time
 * For every new insertion we only need to balance once.. everything else should remain 
 * balanced.
 * 
 * height of tree =  max(height of left subtree, height of right subtree) + 1
 * 
 * height of empty tree = -1
 * height of tree with one node = 0
 * 
 * Balance factor of any node = | height of left subtree - height of right subtree | < = 1
 *   
 * Balancing a Subtree :
 * 1. Get the balance factor of the subtree
 * 2. Decide which child is taller
 * 3. Get balance factor of the taller child
 * 4. Perform necessary rotations (left rotation or right rotation)
 * 
 * Cases :
 * 1. Left - Left case : Left subtree is taller (bf = -2,2)and left subtree of left is taller (bf = -1,1)
 *    : Perform right rotation on root of subtree
 * 2. Left - right case : Left subtree is taller and right subtree of left is taller
 *    : Make it a left - left case - by performing a left rotation on left child node
 * 3. Right - Right case : Right subtree is taller and right subtree of right is taller
 *    : Perform left rotation on root of subtree
 * 4. Right - left case : Right subtree is taller and left subtree of right is taller
 *    : Make it a  right-right case - by performing a right rotation on right child node
 *    
 *    AVL Tree is a self balancing BinarySearchTree
 *	  there are other self balancing BinarySearchTrees 
 *    like RedBlackTrees
 *    
 * 
 * 
 */
public class AVLTree {

	public GenericNode<Integer> root;

	public AVLTree() {
		root = null;
	}

	public AVLTree(Integer value) {
		root = new GenericNode<Integer>(value);
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

	public void buildAVLTree(Integer[] itemList) {

		for (int i = 0; i < itemList.length; i++) {

			GenericNode<Integer> newNode = new GenericNode<Integer>(itemList[i]);
				root = insert(root,newNode);
			}
	}
	
	
	public int height(GenericNode<Integer> node) {
		if(node == null) {
			return -1;
		} else {
			return 1 + Math.max(height(node.getPrev()), height(node.getNext()));
		}
	}
	
	public int getBalanceFactor(GenericNode<Integer> node) {
		
		if(node==null) {
			return 0;
		}
		return height(node.getPrev())- height(node.getNext());
		
	}
	
	public GenericNode<Integer> rightRotate(GenericNode<Integer> node){
        GenericNode<Integer> newRoot = node.getPrev();
		node.setPrev(newRoot.getNext());
		newRoot.setNext(node);
		return newRoot;
	}
	
	public GenericNode<Integer> leftRotate(GenericNode<Integer> node){
        GenericNode<Integer> newRoot = node.getNext();
		node.setNext(newRoot.getPrev());
		newRoot.setPrev(node);
		return newRoot;
	}
	

	public GenericNode<Integer> insert(GenericNode<Integer> parentNode, GenericNode<Integer> newNode) {
		
		if(parentNode == null) {
			return newNode;
		}
		if(newNode.getValue() > parentNode.getValue()) {
			parentNode.setNext(insert(parentNode.getNext(),newNode));	
		} else if (newNode.getValue() < parentNode.getValue()) {
			parentNode.setPrev(insert(parentNode.getPrev(),newNode));
		} else {
			return parentNode;
		}
	
		parentNode.setHeight(height(parentNode));
		
		int getBalanceFactorChild = 0;
		int getBalanceFactor = getBalanceFactor(parentNode);
		if(getBalanceFactor > 1) {
		 getBalanceFactorChild = getBalanceFactor(parentNode.getPrev());
		} else if(getBalanceFactor < -1){
		 getBalanceFactorChild = getBalanceFactor(parentNode.getNext());
		}
		
		//left - left
		if(getBalanceFactor > 1 && getBalanceFactorChild > 0) {
			parentNode = rightRotate(parentNode);
		}
		//left - right
		if(getBalanceFactor > 1 && getBalanceFactorChild < 0) {
			parentNode.setPrev(leftRotate(parentNode.getPrev()));
			parentNode = rightRotate(parentNode);
		}
		
		// right - right
		if(getBalanceFactor < -1 && getBalanceFactorChild < 0) {
			parentNode = leftRotate(parentNode);
		}
		
		// right - left
		if(getBalanceFactor < -1 && getBalanceFactorChild > 0) {
			parentNode.setNext(rightRotate(parentNode.getNext()));
			parentNode = leftRotate(parentNode);
		}
		
		return parentNode;
		
			
	}

}
