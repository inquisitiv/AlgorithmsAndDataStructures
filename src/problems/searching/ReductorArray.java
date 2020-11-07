package problems.searching;

import java.util.Arrays;

public class ReductorArray {
	int reductorArray(int[] a, int[] b, int d) {
		   
		   Arrays.sort(a);
		   Arrays.sort(b);
		   int count = 0;
		   for(int i=0;i<a.length;i++) {
		       boolean flag = isPossible(a[i],b,d);
		       if(flag==true) {
		           count ++;
		       }
		   }
		   return count;
		   
		}

		boolean isPossible(int a, int[] b, int d) {
		    
		   for(int i=0;i<b.length;i++) {
		       if(Math.abs(b[i]-a)<=d) {
		           return false;
		       }
		   }
		   return true;
		   
		}

}
