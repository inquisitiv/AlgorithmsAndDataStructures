package com.easy;

import java.util.Arrays;

class Solution1 {
	
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] {2,3}));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        double ans = 0.0;
	        double temp = 0.0;
	        int[] num = merge(nums1,nums2);
	        if(num.length == 1) {
	            return num[0];
	        }
	        if(num.length%2==0){
	            ans = num[(num.length/2)-1];
	            temp = num[(num.length/2)];
	            ans = (ans+temp)/2;
	        } else {
	            ans = num[(num.length/2)];
	            
	        }
	        return ans;
	    }
	    
	  public static int[] merge(int[] nums1, int[] nums2) {
	        
	        int[] num3 = new int[nums1.length+nums2.length];
	        
	        int i = 0;
	        int j = 0;
	        int k = 0;
	        
	        while(i<nums1.length && j<nums2.length) {
	            
	            if(nums1[i]<nums2[j]){
	                num3[k++]=nums1[i++];
	            }else{
	                num3[k++]=nums2[j++];
	            }
	        }
	          while(i<nums1.length) {
	            num3[k++]=nums1[i++];
	          }
	          while(j<nums2.length) {
	            num3[k++]=nums2[j++];
	        }
	        
	        return num3;
	        
	        foreach  
	        
	    }
	
}