package algorithms.trees;

/*
 * Since heap is a binary tree,
 * It can be stored in a flat array
 * 
 * 0th pos is unused
 * Parent any n = Math.ceil(pos of n/2)
 * Left child of n = pos of n * 2
 * Right child of n = pos of n * 2 + 1
 * 
 * Building heap takes O(n) time.
 * 
 * 
 */

public class HeapSort {
	
	Integer[] array;
	int heapSize;
	
	public HeapSort(Integer[] array) {
		// TODO Auto-generated constructor stub
		this.array = array.clone();
		heapSize = this.array.length;
	}
	
	public void heapify(int loc) {
		
		int largest = loc;
		int left = loc*2+1;
		int right = loc*2+2;
		
		if(left<heapSize && array[left] > array[largest]) {
			largest = left;
		} 
		
		if (right<heapSize && array[right] > array[largest]) {
			largest = right;
		}
		
		if(largest!= loc) {
			int temp = array[loc];
			array[loc] = array[largest];
			array[largest] = temp;
			heapify(largest);
		}
		
		
	}
	
	public void buildMaxHeap() {
		
		int startLocation = (heapSize/2)-1 ;
		for (int i = startLocation; i >= 0; i--) {
			heapify(i);
		}
		
	
	}
	
	public void heapSort() {
		
		buildMaxHeap();
		runheapSortLogic();
		
	}
	
	public void runheapSortLogic() {
		
		while(heapSize > 0){
		    int lastNode = array[heapSize-1];
			int largest = array[0];
			array[0] = lastNode;
			array[heapSize-1] = largest;
			heapSize--;
			heapify(0);
		}
		
	}
	
	

}
