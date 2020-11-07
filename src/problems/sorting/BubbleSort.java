package problems.sorting;

import java.util.Arrays;

/*
 * The above function always runs O(n^2) time even if the array is sorted.
 * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
 * 
 */

public class BubbleSort {
	public static void main(String[] args) {
		//int[] array = new int[] { 10, 18, 22, 13, 12, 47, 33, 42, 16, 19, 20, 21, 23, 24, 35 };
		int[] array = new int[] {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
		int element = 21;

		System.out.println(Arrays.toString(array));
		bubbleSort(array, element);
		System.out.println(Arrays.toString(array));
	}

	public static void bubbleSort(int[] array, int element) {

		boolean swap = false;
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length-i-1; j++) {

				if (array[j] > array[j+1]) {
					
					swap(array, j, j+1);
					swap = true;
				}
			}
			if(swap==false) {
				break;
			}
			swap = false;
			
		}
	}

	public static void swap(int[] args, int i, int j) {
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}
}
