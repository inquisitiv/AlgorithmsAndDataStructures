package topicwise.practice.backtracking;

public class MedianOfSortedArrays {
	
	    public static void main(String[] args) {
		 
	    	System.out.println(findMedianSortedArrays(new int[] {100001}, new int[] {100000})); 
	    	
	    }

	    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	    	int[] num3 = merge(nums1,nums2);
	        int len = num3.length;
	        if(len==0){
	            return -1;
	        }
	        int index = len/2;
	        if(len%2!=0){
	          return num3[index];
	        } else {
	          return ((double)(num3[index]+num3[index-1]))/2;
	        }
	        
	    }
	    
	    public static int[] merge(int[] num1, int[]num2) {
	        
	        int len1 = num1.length;
	        int len2 = num2.length;
	        int[] num3 = new int[len1+len2];
	        int i=0,j=0,k=0;
	        
	        while(i<len1 && j<len2) {
	           
	            if(num1[i]<num2[j]){
	              num3[k++] = num1[i++];
	            } else {
	              num3[k++] = num2[j++];  
	            }    
	            
	            
	        }
	        while(i<len1) {
	            num3[k++] = num1[i++];
	        }
	        while(j<len2){
	            num3[k++] = num2[j++];
	        }
	        
	        return num3;
	        
	    }
	    
	
}
