package problems.aditya.dynamicProgramming;
// also same as TargetSum

public class SubsetWithGivenDifference {
	
	public static boolean[][] t;

	public static void main(String[] args) {
		
	   	int[] arr = new int[] {1,2,9};
	   	int diff = 5;
	   	long sum = 0;
	   	for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
	   	if((sum - diff)%2!=0) {
	   		System.out.println(false);
	   	} else {
		   	int sumfinal = (int) ((sum - diff)/2);
		   	t = new boolean[arr.length+1][sumfinal+1];
		   	System.out.println(knapsack(arr,sumfinal,arr.length));
	   	}
	}
	
	public static boolean knapsack(int[] arr, int sum,int n) {
	
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
	
		return t[n][sum];
		
		
	}
	
}
