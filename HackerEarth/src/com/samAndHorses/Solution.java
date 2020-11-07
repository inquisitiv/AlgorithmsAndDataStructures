package com.samAndHorses;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
   
   public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	  int n = input.nextInt();
	  int[][] arr = new int[n][n];
	  for(int i=0; i<n; i++) {
		  for(int j=0; j<n; j++) {
			  arr[i][j] = input.nextInt();
		  }
	  }
	  
	 System.out.println(maxArea(arr,n));
	  
   }
   
   public static int maxArea(int[][] arr, int n) {
   
	   int[][] horizontal = new int[n][n];
	   int[][] vertical = new int[n][n];
	   int countH = 0;
	   
	   for(int i=0; i<n; i++) {
		   
			  for(int j=0; j<n; j++) {
				  if(arr[i][j] == 1) {
					int jStart = j;
					countH = 0;
					while(i<n && j<n && arr[i][j] == 1) {
						countH = countH+1;
						j++;
					}
					for(int k=jStart;k<j;k++) {
						horizontal[i][k] = countH;
					}
					if(j>jStart) {
						j = j-1;
					}
				  }
			  }
		  }
	   
	   for(int j=0; j<n; j++) {
		  for(int i=0; i<n; i++) {
			  if(arr[i][j] == 1) {
					int iStart = j;
					countH = 0;
					while(i<n && j<n && arr[i][j] == 1) {
						countH = countH+1;
						i++;
					}
					for(int k=iStart;k<i;k++) {
						vertical[k][j] = countH;
					}
					if(i>iStart) {
						i = i-1;
					}
				  }
		  }
	   }
	   System.out.println(Arrays.deepToString(horizontal));
	   System.out.println(Arrays.deepToString(vertical));
	   int max = 0;
	   for(int i=0; i<n; i++) {
		   
			  for(int j=0; j<n; j++) {
				  max = Math.max(max,horizontal[i][j] + vertical[i][j]);
			  }
	    }
	   return max-1;
	   
   }
   
   
}
