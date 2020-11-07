package problems.arrays;

public class SubArrayWithLeastAverage {

	public static void main(String[] args) {
	
		int[] numbers = { 3, 7, 90, 20, 10, 50, 40 };
		int windowL = 3;
		int size = numbers.length;
		if(windowL>size){
			System.out.println("No Such SubArray");
		}
		if(windowL==size){
			System.out.println("Array is the SubArray");
		}
		int sumWindow = 0;
		int leastAverage = 0;
		for (int k=0; k< windowL; k++) {
			sumWindow = numbers[k]+sumWindow;
		}
		leastAverage = sumWindow;
		int startIndex = 0;
		int endIndex = windowL-1;
		for (int i=windowL; i< numbers.length; i++) {
			int temp = sumWindow+numbers[i]-numbers[i-windowL];
			if(temp<sumWindow) {
				leastAverage = temp;
				startIndex = i-windowL+1;
				endIndex = i;
			}
			sumWindow = temp;
		}
		System.out.println("Least Average SubArray Sum :" + leastAverage);
		System.out.println("Least Average SubArray: startIndex: " + startIndex + ": endIndex: " + endIndex);
	}
}
