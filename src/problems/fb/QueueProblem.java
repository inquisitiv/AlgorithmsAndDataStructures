package problems.fb;

import java.util.*;

class QueueProblem {
    
    public static void flip(int[] arr, int start, int end) {
        int temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        
        
    }
    
    public static List<Integer> pancakeSort(int[] arr) {
        
       List<Integer> result = new ArrayList<>(); 
       int count = 1;
       while(true){ 
        int maxIndex = 0;
        for(int i=1;i<=arr.length-count;i++) {
            if(arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
        }
        if(maxIndex<arr.length-count) {
          System.out.println(Arrays.toString(arr));
          flip(arr,0,maxIndex);
          System.out.println(Arrays.toString(arr));
          flip(arr,0,arr.length-count);
          System.out.println(Arrays.toString(arr));
          count++;
          result.add(maxIndex+1);  
        } else {
            return result;
        }
       }
      
       
    }
    
    public static void main(String[] args) {
		System.out.println(pancakeSort(new int[] {3,2,4,1}).toString());
	}
}