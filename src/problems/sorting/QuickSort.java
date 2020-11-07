package problems.sorting;

import java.util.Arrays;

/*
 * O(n log n) in average and best case
 * O(n^2) in worst case 
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		
		int[] array = new int[] { 10, 18, 22, 13, 12, 47, 33, 42, 16, 19, 20, 21, 23, 24, 35 };
		

		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int[] array, int low, int high) {

		if (low < high) {

			int pivot = array[low + (high - low) / 2];
			System.out.println("Pivot is :" + pivot);
			int pivotLocation = partition(array, low, high, pivot);
			System.out.println("Pivot is :" + pivotLocation);
			System.out.println("Partioned Array :" + Arrays.toString(array));
			quickSort(array, low, pivotLocation-1);
			quickSort(array, pivotLocation+1, high);
		}

	}

	public static int partition(int[] array, int low, int high, int pivot) {

		int left = low;
		int right = high;

		while (left < right) {

			while (array[left] < pivot) {
				left++;
			}

			while (array[right] > pivot) {
				right--;
			}

			if (left < right) {
				swap(array, left, right);
			}

		}
		return left;

	}

	public static void swap(int[] args, int i, int j) {
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}
}
