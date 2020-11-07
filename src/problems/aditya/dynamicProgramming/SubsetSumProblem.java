package problems.aditya.dynamicProgramming;

public class SubsetSumProblem {

	public static boolean[][] t;

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 5, 7, 8, 9 };
		int sum = 11;
		t = new boolean[arr.length + 1][sum + 1];
		System.out.println(isSubsetsumPresent(arr, sum, arr.length));

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
