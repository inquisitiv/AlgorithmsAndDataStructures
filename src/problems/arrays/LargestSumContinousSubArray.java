package problems.arrays;

public class LargestSumContinousSubArray {
	
	public static void main(String[] args) {
		
	    int[] nums = {-2,4,6,-7,8,6,-1,-2};
	    int[] result = findLargestSumSubArray(nums);
	    System.out.println(result[0]+ "-" + result[1]);
		
	}	
	
	//Kadane's algorithm
	public static int[] findLargestSumSubArray(int[] array) {
		int max_ending_here = 0;
		int max_so_far = 0;
		int startIndex = 0;
		int endIndex = 0;
		int[] subArrayIndex = new int[2];
		for(int i=0;i<array.length;i++) {
			max_ending_here = max_ending_here + array[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
				startIndex = i+1;
			} else if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				endIndex = i;
			} 
			
		}
		subArrayIndex[0]= startIndex;
		subArrayIndex[1]= endIndex;	
		return subArrayIndex;
		
	}

}
