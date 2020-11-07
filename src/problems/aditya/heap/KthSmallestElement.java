package problems.aditya.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {11,12,3,4,15,5,6,19};
		System.out.println(kthsmallest(arr,3));
	
	}

	private static int kthsmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if(maxHeap.size()>k) {
				maxHeap.remove();
			}
			
		}
		return maxHeap.remove();
		
	}
}
