package topicwise.practice.backtracking;

import java.util.*;

public class PankcakeSort {
	
	   public static void main(String[] args) {
		
		   PankcakeSort pncke = new PankcakeSort();
		   int[] arr = new int[]{1,3,4,2};
		   pncke.pancakeSort(arr);
		   System.out.println(Arrays.toString(arr));
				   
		   
	   }

	    public List<Integer> pancakeSort(int[] arr) {
	        
	        List<Integer> result = new ArrayList<>();
	        int n = arr.length-1;
	        while(n>0) {
	          int index = findMaxIndex(arr,n);
	          if(index<n) {
	              if(index==0){
	                 flip(arr,n);
	                 result.add(n+1); 
	              }else {
	                 flip(arr, index);
	                 result.add(index+1);
	                 flip(arr, n);
	                 result.add(n+1);
	              }
	          }
	          n=n-1;  
	        }
	        return result;
	    }
	    
	    public int findMaxIndex(int[] arr, int n) {
	        
	        int index = 0;
	        for(int i=1;i<=n;i++) {
	            if(arr[i]>arr[index]) {
	                index = i;
	            }
	            
	        }
	        return index;
	        
	        
	    }
	    
	    public void flip(int[] arr, int end) {
	        
	        if(end>0){
	            
	           for(int i=0; i<=end/2; i++) {
	               int temp = arr[i];
	               arr[i] = arr[end-i];
	               arr[end-i] = temp;
	           } 
	            
	        }
	        
	    }
	
}
