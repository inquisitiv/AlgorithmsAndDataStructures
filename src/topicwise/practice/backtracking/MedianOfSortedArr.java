package topicwise.practice.backtracking;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianOfSortedArr {
	
	    public static void main(String[] args) {
	    	System.out.println(findMedianSortedArrays(new int[] {100001}, new int[] {100000})); 
	    	
	    	PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		}
	    
	    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        int len1 = nums1.length;
	        int len2 = nums2.length;
	        if(len1==0) {
	        	if(len2%2!=0) {
	        	  return nums2[(len2)/2];
	        	} else {
	        		return ((double)nums2[(len2)/2-1]+nums2[len2/2])/2;
	        	}
	        }
	        if(len2==0) {
	        	if(len1%2!=0) {
	        	  return nums1[(len1)/2];
	        	} else {
	        		return ((double)nums1[(len1/2)-1]+nums1[len1/2])/2;
	        	}
	        }
	        int total;
	        if((len1+len2)%2==0){
	            total = (len1+len2)/2;
	        } else {
	            total = (len1+len2-1)/2 + 1;
	        }
	        int low = 0;
	        int high = nums1.length-1;
	        System.out.println("nums1: " + Arrays.toString(nums1));
	        System.out.println("nums2: " + Arrays.toString(nums2));
	        while(low<=high){
	            int partX = (low+high)/2;
	            int eleC = partX+1;
	            int left = total-eleC;
	            int partY = left-1;
	            
	            int leftX = getLeft(nums1,partX);
	            int rightX = getRight(nums1,partX);
	            int leftY = getLeft(nums2,partY);
	            int rightY = getRight(nums2,partY);
	            System.out.println("partX: " + partX);
	            System.out.println("partY: " + partY);
	            
	            if(leftX<=rightY && leftY<=rightX){
	            	if((len1+len2)%2!=0) {
	            		return Math.max(leftX,leftY);
	            	} else {
	                  return (Math.max(leftX,leftY)+Math.min(rightX,rightY))/2.0;
	            	}
	            }
	            
	            if(leftX>rightY) {
	                high = partX-1;
	                if(high==-1) {
	                	low=-1;
	                }
	            } else {
	                low = partX+1;
	                if(low==nums1.length) {
	                	high = nums1.length;
	                }
	            }
	        }
	        return -1;
	        
	        
	    }
	    
	    public static int getLeft(int[] nums, int part){
	        
	        if(part>=0){
	        	 return nums[part];
	        }
	        return Integer.MIN_VALUE;
	       
	        
	    }
	    
	     public static int getRight(int[] nums, int part){
	        
	        if((part+1)<nums.length){
	        	return nums[part+1];
	        }
	        return Integer.MAX_VALUE;
	        
	        
	    }
	    
	    
	

}
