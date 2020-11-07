package entities;

public class DoublyLinkedList<T> {
	
	private GenericNode<T> head;
	private GenericNode<T> tail;
	

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	
	public DoublyLinkedList(T value) {
		head = new GenericNode<T>(value);
		tail = head;
	}
	
	public GenericNode<T> getHead() {
		return head;
	}


	public void setHead(GenericNode<T> head) {
		this.head = head;
	}

	
	public GenericNode<T> getTail() {
		return tail;
	}


	public void setTail(GenericNode<T> tail) {
		this.tail = tail;
	}

	public void insertAtHead(T value) {
		GenericNode<T> temp = new GenericNode<T>(value);
		if(head == null) {
			head = temp;
			tail = temp;
		} else {
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
		} 
	}
	
	public void insertAtTail(T value) {
		GenericNode<T> temp = new GenericNode<T>(value);
		if(head == null){
			head = temp;
			tail = temp;
		} else {
			temp.setPrev(tail);
			tail.setNext(temp);
			tail = temp;
		}
	}
	
	public GenericNode<T> removeFromTail() {
		GenericNode<T> temp = tail;
		if(head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);
		} 
		return temp;
	}
	
	public void printFromHeadToTail(GenericNode<T> head) {
		if(head == null) {
			System.out.println("Empty Doubly LinkedList");
		} else {
			GenericNode<T> temp = head;
			while(temp != null) {
				System.out.print(temp.getValue().toString() +"<=>");
				temp = temp.getNext();
			}
			
		}
	}

}
