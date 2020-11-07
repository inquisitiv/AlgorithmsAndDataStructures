package problems.aditya.dynamicProgramming;

public class KnapsackDP {

	public static int[][] t;

	public static void main(String[] args) {
		int[] w = new int[] { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4 };
		int[] val = new int[] { 10, 20, 30, 40, 50, 5, 15, 35, 45, 55 };
		int wt = 10000;
		int n = 10;
		t = new int[n + 1][wt + 1];
		long start = System.currentTimeMillis();
		System.out.println(knapsack(w, val, wt, n));
		System.out.println(System.currentTimeMillis() - start);

	}

	public static int knapsack(int[] w, int[] val, int wt, int n) {

		// Initialization for base condition
		for (int i = 0; i < n + 1; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j < wt + 1; j++) {
			t[0][j] = 0;
		}

		// top-down dp
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < wt + 1; j++) {
				if (w[i - 1] <= j) {
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - w[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		
		return t[n][wt];

	}

}
