package problems.sorting;

/*
 * Runtime : O(m log n)
 * 
 * 
 */
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[] { 10, 18, 22, 13, 12, 47, 33, 42, 16, 19, 20, 21, 23, 24, 35 };
		// int[] array = new int[] { 2,1};
		int[] temp = new int[array.length];
		System.out.println(Arrays.toString(array));
		mergeSort(array, temp, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void mergeSort(int[] array, int[] temp, int low, int high) {

		if (low < high) {
			int partition = low + (high - low) / 2;
			mergeSort(array, temp, low, partition);
			mergeSort(array, temp, partition + 1, high);
			merge(array, temp, low, partition, high);
		}

	}

	public static void merge(int[] array, int[] temp, int low, int mid, int high) {

		int leftStart = low;
		int rightStart = mid + 1;
		int index = low;

		while (leftStart <= mid && rightStart <= high) {
			if (array[leftStart] < array[rightStart]) {
				temp[index++] = array[leftStart++];
			} else {
				temp[index++] = array[rightStart++];
			}
		}
		System.arraycopy(array, leftStart, temp, index, mid - leftStart + 1);
		System.arraycopy(array, rightStart, temp, index, high - rightStart + 1);
		System.arraycopy(temp, low, array, low, high - low + 1);

	}

}
