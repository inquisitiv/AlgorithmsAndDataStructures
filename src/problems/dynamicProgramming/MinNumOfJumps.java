package problems.dynamicProgramming;

//Dynamic Programming
public class MinNumOfJumps {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] jumps = new int[nums.length];

		jumps[nums.length - 1] = 0;
		int min;

		for (int i = nums.length - 2; i >= 0; i--) {

			if (nums[i] == 0) {
				jumps[i] = Integer.MAX_VALUE;
			} else if (nums[i] >= nums.length - i - 1) {
				jumps[i] = 1;
			} else {
				min = Integer.MAX_VALUE;
				for (int j = i+1; j< nums.length && j <= nums[i] + i; j++) {
					if (min > jumps[j]) 
	                    min = jumps[j]; 
				}
				if (min != Integer.MAX_VALUE) 
	                jumps[i] = min + 1; 
	            else
	                jumps[i] = min;
			}

		}
		System.out.println("Minimum number of steps: " + jumps[0]);

	}

}
