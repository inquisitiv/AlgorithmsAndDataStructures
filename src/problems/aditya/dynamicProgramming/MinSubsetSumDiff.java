package problems.aditya.dynamicProgramming;

public class MinSubsetSumDiff {
	
	public static boolean[][] t;

	public static void main(String[] args) {
		
	   	int[] arr = new int[] {1,2,7};
	   	long sum = 0;
	   	for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		int sumfinal = 0;
	   	if(sum%2!=0) {
	   	   sumfinal = (int)(sum+1/2);
	   	} else {
		   sumfinal = (int)(sum/2);
	   	}
	   	t = new boolean[arr.length+1][sumfinal+1];
	   	System.out.println(knapsack(arr,sumfinal,arr.length,(int)sum));
	}
	
	public static int knapsack(int[] arr, int sum,int n,int fullsum) {
	
		for (int i = 0; i < n+1; i++) {
			t[i][0] = true;
		}
		for (int j = 1; j < sum+1; j++) {
			t[0][j] = false;
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1]<=j) {
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int j=0;
		
		for(j=0;j<sum+1;j++) {
			if(t[n][j]==true) {
			  min = Math.min(min, fullsum-2*j);
			}
		}
		return min;
		
		
	}
	
}
