package problems.sorting;

import java.util.Arrays;
/*
 * 
 * Time Complexity: O(n*2)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
And it takes minimum time (Order of n) when elements are already sorted.
 * 
 * 
 */
public class InsertionSort {

	public static void main(String[] args) {
		
		int[] array = new int[] { 10, 18, 22, 13, 12, 47, 33, 42, 16, 19, 20, 21, 23, 24, 35 };
		int element = 21;

		System.out.println(Arrays.toString(array));
		insertionSort(array, element);
		System.out.println(Arrays.toString(array));
		
	}
	
	public static void insertionSort(int[] arr, int element) {

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && key<arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
}
