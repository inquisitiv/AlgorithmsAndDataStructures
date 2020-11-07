package problems.searching;

public class BinarySearch {
	public static void main(String[] args) {

		int[] array = new int[] { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };
		int element = 21;

		binarySearch(array, element);

	}

	public static void binarySearch(int[] array, int element) {

		boolean found = false;
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (array[mid] == element) {
				System.out.println("Element found at pos :" + mid);
				found = true;
				break;
			} else if (array[mid] > element) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		if(found == false) {
			System.out.println("Element not found");
		}

	}
}
