package entities;

public class GenericNode<T> {
	
	private GenericNode<T> prev;
	private T value;
	private int height;
	private GenericNode<T> next;
	private GenericNode<T> parent;

	
	public GenericNode(T value) {
		this.next = null;
		this.prev = null;
		this.parent = null;
		this.value = value;
	}
	
	public GenericNode<T> getPrev() {
		return prev;
	}


	public void setPrev(GenericNode<T> prev) {
		this.prev = prev;
	}
	
	public GenericNode<T> getParent() {
		return parent;
	}


	public void setParent(GenericNode<T> parent) {
		this.parent = parent;
	}
	
	
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public GenericNode<T> getNext() {
		return next;
	}


	public void setNext(GenericNode<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


}
