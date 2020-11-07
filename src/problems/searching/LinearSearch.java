package problems.searching;
/*
 * Linear Search finds the element in O(n) time,
 * Jump Search takes O(√ n) time and Binary Search take O(Log n) time.
 * The Interpolation Search is an improvement over Binary Search for instances, 
 * where the values in a sorted array are uniformly distributed.
 * 
 *  
 *  The time complexity of Jump Search is between
 *  Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).
 *  Its  root(n) 
 */
public class LinearSearch {

	public static void main(String[] args) {
		
		int[] array = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 
                24, 33, 35, 42, 47}; 
		
		int element = 21;
		boolean found = false;
		
		for(int i=0;i<array.length;i++) {
			if(element == array[i]) {
			System.out.println("Found value " + element + " at pos " + i);
			found = true;
			}
		}
		
		if(found == false) {
			System.out.println("Element not found");
		}
		
	}
	
}
