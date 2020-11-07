package problems.aditya.dynamicProgramming;

public class CountOfSubsetSum {

	public static int[][] t;

	public static void main(String[] args) {

		int[] arr = new int[] { 2, 3, 5, 8, 10 };
		int sum = 10;
		t = new int[arr.length + 1][sum + 1];
		System.out.println(knapsnack(arr, sum, arr.length));
	}

	public static int knapsnack(int[] arr, int sum, int n) {

		for (int i = 0; i < n + 1; i++) {
			t[i][0] = 1;
		}
		for (int j = 1; j < sum + 1; j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j) {
                   t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}

			}
		}
		
		return t[n][sum];

	}

}