package main;

import algorithms.lru.LRUCach;
import entities.DoublyLinkedList;
import entities.GenericNode;

public class MainApplication {
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		
		dll.insertAtTail(1);
		dll.insertAtTail(2);
		dll.insertAtTail(3);
		dll.insertAtTail(4);
		dll.insertAtTail(5);
		dll.insertAtTail(6);
		
		dll.printFromHeadToTail(dll.getHead());
		
		
		LRUCach lru = new LRUCach();
		System.out.println();
		System.out.println("LRU Cache Implementation");
		System.out.println(lru.getPageFromCache(1));
		System.out.println(lru.getPageFromCache(2));
		System.out.println(lru.getPageFromCache(3));
		System.out.println(lru.getPageFromCache(4));
		System.out.println(lru.getPageFromCache(1));
		System.out.println(lru.getPageFromCache(3));
		System.out.println(lru.getPageFromCache(5));
		System.out.println(lru.getPageFromCache(6));
		System.out.println(lru.getPageFromCache(7));
		System.out.println(lru.getPageFromCache(5));
		System.out.println(lru.getPageFromCache(1));
		System.out.println(lru.getPageFromCache(4));
		System.out.println(lru.getPageFromCache(5));
		System.out.println(lru.getPageFromCache(9));
		
		
		//Node<Integer> rootNode = generateATestBinaryTree();
		
		
	}
	

	
	

}
