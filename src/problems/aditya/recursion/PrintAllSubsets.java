package problems.aditya.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PrintAllSubsets {

	public static void main(String[] args) {
		//int[] arr = new int[] { 1, 1, 3 };
        //HashSet<Integer> subset = new HashSet<Integer>();
	    //printAllSubsets(arr, 0, arr.length, subset);
		//printSubsets(arr);
		//generateBalancedParantheses(3);
		//prefixes(5);
		System.out.println(Arrays.toString(sortUsingRecur(new int[] {12,13,4,15,6})));
	}

	private static int[] sortUsingRecur(int[] arr) {
		// TODO Auto-generated method stub
		
		return sortUsingRecurUtil(arr,0,arr.length-1);
		
		
	}

	private static int[] sortUsingRecurUtil(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end) {
			int[] arrn = new int[arr.length];
			return arrn;
		}
		int temp = arr[end];
		int[] sorted = sortUsingRecurUtil(arr, start, end-1);
		insert(sorted,0,end,temp);
		return sorted;
		
	}
	
	private static void insert(int[] sorted,int start, int end, int temp) {
		// TODO Auto-generated method stub
		if(start==end) {
			sorted[start]= temp;
			return;
		} else if(sorted[end-1]<=temp) {
			sorted[end]= temp;
			return;
		} else if(sorted[end-1]>temp) {
			int num = sorted[end-1];
			insert(sorted, start, end-1, temp);
			sorted[end] = num;
		} 
	}

	private static void prefixes(int i) {
		// TODO Auto-generated method stub
		prefixUtil(i,0,0,"");
	}

	private static void prefixUtil(int i,int ones, int zeros,String str) {
	   
		if(i==0) {
			System.out.println(str);
			return;
		}
		
		if(ones>zeros+1) {
			prefixUtil(i-1,ones,zeros+1,str+"0");
			
		}
		prefixUtil(i-1,ones+1,zeros,str+"1");
		
		
	}
	
	
	private static void generateBalancedParantheses(int i) {
		// TODO Auto-generated method stub
		
		int open = i;
		int close = i;
		util(open,close,"");

	}

	private static void util(int open, int close, String str) {
		if(open<0 || close<0) {
			return;
		} else if(open==0 && close==0) {
			System.out.println(str);
			return;
		}
		// TODO Auto-generated method stub
		util(open-1,close,str+"(");
		if(open<close) {
			util(open,close-1,str+")");
		}
		
	}

	private static void printAllSubsets(int[] arr, int i, int n, HashSet<Integer> subset) {

		if (n - i == 0) {
			System.out.println(subset.toString());
			return;
		}
		printAllSubsets(arr, i + 1, n, new HashSet<Integer>(subset));
		subset.add(arr[i]);
		printAllSubsets(arr, i + 1, n, new HashSet<Integer>(subset));

	}
	
	public static void printSubsets(int[] arr) {
		   
		   HashSet<String> subset = new HashSet<String>();
		   ArrayList<Integer> result = new ArrayList<>();
		   printSubsetsUtil(arr,0,arr.length-1,result,subset);
		   System.out.println(subset.toString());

	}


	private static void printSubsetsUtil(int[] arr,int start, int end, ArrayList<Integer> result, HashSet<String> subset) {
		    if(start>end) {
		      System.out.println(result.toString()); 	
		      subset.add(result.toString());
		      return;
		    }
		    printSubsetsUtil(arr,start+1,end,new ArrayList<>(result),subset);
		    result.add(arr[start]);
		    printSubsetsUtil(arr,start+1,end,new ArrayList<>(result),subset);
		}

}
