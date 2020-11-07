package com.easy;

class SolutionM {
	
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] {7,8,9,11,12}));
	}
    public static int firstMissingPositive(int[] nums) {
     
      int k = 0;  
      int[] posNums = new int[nums.length];
      int[] posNumsSol = new int[nums.length];
      
      int min=0; 
      int max=0;  
      int count = 0;
      for(int i=0;i<nums.length;i++) {
        if(nums[i]>0){  
           posNums[k] = nums[i];
           k++; 
           count++;
           if(nums[i]<min || min==0) {
             min = nums[i]; 
           }
           if(nums[i]>max || max==0) {
             max = nums[i]; 
           }
         }
      }
        
      if(min=!1){
          return 1;
      }  
        
      for(int i=0;i<k;i++) {
    	if((posNums[i]-min)<k) {
         posNumsSol[posNums[i]-min] = -1; 
    	}
      }
        
      for(int i=0;i<k;i++) {
        if(posNumsSol[i] != -1) {
            return i+1;
        }   
      }   
        
      return max+1;  
        
    }
	     

}