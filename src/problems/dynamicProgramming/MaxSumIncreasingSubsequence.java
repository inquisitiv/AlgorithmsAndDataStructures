package problems.dynamicProgramming;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {
	
	public static void main(String[] args) {
	
		int[] array = { 1, 101, 2, 3, 100, 4, 5 };
		int size = array.length;
		int[] lis = new int[size];
		lis = array.clone();
		int max = Integer.MIN_VALUE;
		for(int i=1;i<size;i++) {
			for (int j = 0; j < i; j++) {	
			if(array[i]>array[j] && lis[j]+array[i] > lis[i]) {
			   lis[i] = lis[j]+array[i];
			   if(max < lis[i]) {
				   max = lis[i];
			   }
			}
		   }
		}
		System.out.println();
		System.out.println("MaxSum of Increasing subsequence is : " + max);
	}
}
