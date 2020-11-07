package topicwise.practice.backtracking;
import java.util.*;
import java.io.*;

public class AllocateMinPages {

		public static void main (String[] args)
		 {
		 //code
		 
		 System.out.println(minimum(new int[] {12, 34, 67, 90}, 2));
		 
		 }
		 
		 public static int minimum(int[] values, int m){
		     
		     int min = 0;
		     int max = 0;
		     for(int i=1;i<values.length;i++){
		         max = max + values[i];
		     }
	         System.out.println("max : "+max);   
	         int minRes = 0;   
	         int mid = 0;      	     
	         int result = 0;
	         while(min<max){
	            
	              mid  = min +(max-min)/2;
	              System.out.println("mid : " + mid); 
	              result = tryAllocation(values,m,mid);
	              System.out.println("result : " + result); 
	              if(result == -1) {
	                  min = mid+1;
	              }else{
	            	  if(minRes ==0 || mid<minRes) {
	            		  minRes = mid;
	            	  }
	                  max = mid-1;
	              }
	             
	             
	         }
	         return minRes;
	 
		 }
		 
		 public static int tryAllocation(int[] values, int m, int max) {
		     
		     int index=-1;
		     //int count = 0;
		     int i=0;
		     for(i=0;i<m-1;i++){
		         int allocation = 0;
		         while(index<(values.length-1) && allocation<max){
		        	 index++;
		             allocation = allocation + values[index];
		             if(allocation>max) {
		            	 allocation = allocation - values[index];
		            	 index = index-1;
		            	 break;
		             }
		         }
		         System.out.println("allocation " + (i+1) + ":" + allocation);
		         if(allocation>0){
		            // count++;
		         }
		     }
		     int allocation = 0;
		     index++;
		     while(index<values.length) {
		       allocation = allocation + values[index];
		       index++;
		     }
		     System.out.println("allocation " + (i+1) + ":" + allocation);
		     if(allocation>0){
		       //count++;
		      }
		      if(allocation>max || allocation<=0) {
		          return -1;
		      }
		      return 0;
		      
		 }
		 
		 
	
}
