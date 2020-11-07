package problems.arrays;

public class MinDistBtwnTwoNumInUnsortedArray {

	public static void main(String[] args) {
		int[] array = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 3 };
		int x = 3;
		int y = 6;
		int prev = -1;
		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == x || array[i] == y) {
				if (prev != -1 && array[prev] != array[i]) {
					minDist = Math.min(i - prev, minDist);
				}
				prev = i;
			}
		}
		System.out.println("Minimum Distance between x: " + x + " y: " + y + " is " + minDist);

	}
}
