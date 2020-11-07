package problems.fb;

import java.util.*;

public class AverageSum {

	
	public static ArrayList<int[]> aboveAvg(int[] A) {
		
		ArrayList<int[]> result = new ArrayList<>();
		int sum = 0;
		for(int i=0;i<A.length;i++) {
			sum = sum + A[i];
			A[i] = sum;
		}
		for(int i=0;i<A.length;i++) {
			for(int j=i;j<A.length;j++) {
				int arraySum = 0;
				if(i==0) {
					arraySum = A[j];
				} else {
					arraySum = A[j]-A[i-1];
				}
				int len1 = j-i+1;
				int otherSum = sum - arraySum;
				int len2 = A.length-len1;
				if(len2!=0) {
					otherSum = otherSum/len2;
				}
				if(arraySum>otherSum) {
					int[] temp = new int[2];
					temp[0] = i+1; 
					temp[1] = j+1;
					result.add(temp);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		ArrayList<int[]>  result = aboveAvg(new int[] {3,4,2});
		for (int i=0; i<result.size(); i++){
		    System.out.print("["+result.get(i)[0]+",");
		    System.out.println(result.get(i)[1]+"]");
		}
		
	}
	
}
