package topicwise.practice.backtracking;

import java.util.HashSet;

public class MissingFirstPositive {
	
	    public static void main(String[] args) {
			MissingFirstPositive m = new MissingFirstPositive();
			System.out.println(m.firstMissingPositive(new int[] {1,2,3,10,2147483647,9}));
		}
	
	    public int firstMissingPositive(int[] nums) {
	        
	       HashSet<Integer> pq = new HashSet<>(); 
	       int max=Integer.MIN_VALUE;
	       for(int i=0;i<nums.length;i++){
	           if(nums[i]>0){
	               pq.add(nums[i]);
	               if(nums[i]>max){
	                   max = nums[i];
	               }
	           }
	       }
	        
	       System.out.println(max); 
	       for(int i=1;i<=max;i++){
	           if(!pq.contains(i)){
	               return i;
	           }
	       }  
	        
	       return max+1;
	        
	       
	        
	    }
	
}
