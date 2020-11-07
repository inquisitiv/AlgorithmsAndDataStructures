package problems.aditya.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterToRightForEveryElement {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,4,1,2,3,4,5};
		
		System.out.println(Arrays.toString(nextGreatestToRight(arr)));
		
	}

	private static int[] nextGreatestToRight(int[] arr) {
		
		Stack<Integer> stack = new Stack<Integer>();
	   	int[] result = new int[arr.length];
	   	
	   	for (int i = arr.length-1; i >= 0; i--) {
			
	   		if(i==arr.length-1) {
	   			result[i]=-1;
	   			stack.push(arr[i]);
	   		} else {
	   			while(stack.peek()<=arr[i]) {
	   				stack.pop();
	   			}
	   			if(stack.isEmpty()) {
	   				result[i] = -1;
	   				stack.push(arr[i]);
	   			} else {
	   				result[i] = stack.peek();
	   				stack.push(arr[i]);
	   			}
	   			
	   		}
	   		
		}
	   	
	   	return result;
	   	
		
	}
	
	
}
