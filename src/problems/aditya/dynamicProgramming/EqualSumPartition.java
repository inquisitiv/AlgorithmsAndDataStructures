package problems.aditya.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class EqualSumPartition {

	public static boolean[][] t;

	public static void main(String[] args) {
		int[] arr = new int[] {6,8,18,3,1};
		List<Integer> kd = new ArrayList<>();
		kd.toArray();
		long sum = 0;
		for (int a : arr) {
			sum = sum + a;
		}
		if (sum % 2 != 0) {
			System.out.println("false");
		} else {
			sum = sum / 2;
			t = new boolean[arr.length + 1][(int) (sum + 1)];
			System.out.println(isSubsetsumPresent(arr, (int) (sum), arr.length));
		}

	}

	public static boolean isSubsetsumPresent(int[] arr, int sum, int n) {

		// intialize table t
		for (int i = 0; i < n + 1; i++) {
			t[i][0] = true;
		}
		for (int j = 1; j < sum + 1; j++) {
			t[0][j] = false;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum];

	}

}
