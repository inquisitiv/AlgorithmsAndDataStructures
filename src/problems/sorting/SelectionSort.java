package problems.sorting;

import java.util.Arrays;

/*
 * 
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n)
 * swaps and can be useful when memory write is a costly operation. 
 *  
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = new int[] { 10, 18, 22, 13, 12, 47, 33, 42, 16, 19, 20, 21, 23, 24, 35 };
		int element = 21;

		System.out.println(Arrays.toString(array));
		selectionSort(array, element);
		System.out.println(Arrays.toString(array));
	}

	public static void selectionSort(int[] array, int element) {

		for (int i = 0; i < array.length; i++) {
			int min = i;

			for (int j = i+1; j < array.length; j++) {

				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
	}

	public static void swap(int[] args, int i, int j) {
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}

}
