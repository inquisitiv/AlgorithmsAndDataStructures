package algorithms.trees;

import java.util.Arrays;

public class Application {
	
	public static void main(String[] args) {
		
		Integer[] elementList = new Integer[] {1,2,3,4,5,6,7,8,9,10};
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.createTree(elementList);
		tree.levelOrderTraversal();
		
		/*tree.buildTreeInLevelOrderTraversal(elementList);
	    tree.levelOrderTraversal();
	    tree.preOrderTraversal();
	    tree.postOrderTraversal();
	    tree.inOrderTraversal();
	    
	    tree.insertElement(11);
	    tree.insertElement(12);
	    tree.insertElement(13);
	    tree.insertElement(14);
	   
	    tree.levelOrderTraversal();
	    
	    System.out.println("---------------------------------");*/
	    
	    /* Tree Sort
	    * Constructing BST :
	    * if already sorted/reverse sorted = O(n^2)
	    * - create balanced tree .. 
	    * Balancing reduces worst case to O(nlogn) time complexity
	    * Inorder Traversal = O(3n) = O(n)
	    *
	    */
	    /*Integer[] itemList = new Integer[] {6,5,3,8,9,1,2,4,7,10};
	    
	    //Integer[] itemList = new Integer[] {1,2,3,4,5,6,7,8,9,10};
	    
	    BinarySearchTree bst = new BinarySearchTree();
	    
	    bst.buildBinarySearchTree(itemList);
	    bst.levelOrderTraversal();
	    bst.inOrderTraversal();
	    
	    AVLTree avlTree = new AVLTree();
	    
	    avlTree.buildAVLTree(itemList);
	    avlTree.inOrderTraversal();
	    avlTree.levelOrderTraversal();
	    /*
        BinaryHeap heap = new BinaryHeap();
	    
        heap.buildMinHeap(itemList);
        heap.levelOrderTraversal();
        Integer[] sortedList = heap.extactMinAndSort();
        System.out.println(Arrays.toString(sortedList));
        
        HeapSort heaps = new HeapSort(itemList);
        heaps.heapSort();
        System.out.println(Arrays.toString(heaps.array));*/
        
	    
	
	}

}
