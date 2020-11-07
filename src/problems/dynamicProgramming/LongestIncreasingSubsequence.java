package problems.dynamicProgramming;

import java.util.Arrays;

//Dynamic Programming
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] array = { 90, 22, 9, 33, 21, 50, 41, 60, -3, 65 };
		int size = array.length;
		int[] lis = new int[size];
		Arrays.fill(lis, 1);
		int max = 1;

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
					if (max < lis[i]) {
						if (lis[j] == 1) {
							System.out.print(array[j] + ",");
						}
						System.out.print(array[i] + ",");
						max = lis[i];
					}
				}
			}
		}
		System.out.println();
		System.out.println("Length of longest Increasing subsequence is : " + max);

	}
}
