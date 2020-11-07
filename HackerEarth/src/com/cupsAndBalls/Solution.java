package com.cupsAndBalls;

public class Solution {

	
	public static void main(String[] args) {
		
		
	}
	public static int cupsAndBalls(int z, int w, int b) {
		
		int[][][] t= new int[z][w][b];
		for(int i=0; i<w;i++) {
		  for(int j=0; j<b;j++) {
			t[0][i][j] = 0; 
			if(i==0 && j==0) {
			  t[1][i][j] = 0;
			} else if(i==0 || j==0) {
				t[1][i][j] = 1;
			} else {
				t[1][i][j] = 2;
			}
		  }
		}
		
		for(int k=2;k<=z;k++) {
			t[k] = t[k-1][w-1][b] + t[k-1][w-1][b]; 
		}
		
		
		
	}
	
	
	
}
