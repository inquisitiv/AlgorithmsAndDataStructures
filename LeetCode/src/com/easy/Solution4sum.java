package com.easy;

import java.util.*;
class Solution4sum {
	
	public static void main(String[] args) {
		
		System.out.println(fourSum(new int[] {0,0,0,0},0));
		
	}
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int j = 0; j < nums.length-3; j++) {
          if((j==0)||(nums[j]!=nums[j-1])) {   
            int sumN = target-nums[j];
            int low1 = j+1;
            int high1 = nums.length;
        
        for (int i = low1; i < high1-2; i++) {
            
            if((i==low1)||(nums[i]!=nums[i-1])) {
            
                int sum = sumN-nums[i];
                int low = i+1;
                int high = nums.length-1;
                while(low<high) {
                 if(nums[low]+nums[high]==sum) {
                    list.add(Arrays.asList(nums[j],nums[i],nums[low],nums[high]));
                    low++;
                    high--; 
                    while(nums[low]==nums[low-1] && low<high){
                        low++;
                    } 
                    while(nums[high]==nums[high+1] && low<high){
                        high--;
                    }  
                 }else if (nums[low]+nums[high]>sum) {
                     high--;
                 }else {
                     low++;
                 }             
                }
                
            }
            
         }
          }
        }
		return list;
    }
}