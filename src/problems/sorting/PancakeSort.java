package problems.sorting;

import java.util.Arrays;

class PancakeSort {
	

	  static int[] pancakeSort(int[] arr) {
	    // your code goes here
	    int i = arr.length-1;
	    while(i>0) {
	      int j = i-1;
	      int end = j+1;
	      int count = 0;
	      while(j<arr.length-1 && end<arr.length && arr[j]>arr[end]){
	        end++;
	        count++;
	      }
	      if(count>0) {
		      flip(arr,j+1,count);
		      flip(arr,j,count+1);
	      }
	      i=j;
	    }
		   return arr;
	  }
	  
	  static void flip(int[] arr, int start, int k) {
	    
	   if(k<=1) {
		   return;
	   } else {
		   int end = start+k-1;
		   for(int i= start;i<start+(k/2);i++) {
			   int temp = arr[i];
			   arr[i]= arr[end];
			   arr[end] = temp;
			   end--;
		   }
	   }
	  }

	  public static void main(String[] args) {
	    int[] arr = new int[] {13,6,14,10,12,5};
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(pancakeSort(arr)));
	  }

}
