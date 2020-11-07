package problems.arrays;
/*
/*
 * Given two numbers say a and b, mark the multiples of 2 and 5 
 * between a and b using less than O(|b – a|) space and output 
 * each of the multiples.
 */
public class OptimizationUsingBitManipulation {

	public static void main(String[] args) {

		/*
		 * int a = 2; int b = 10; boolean[] result = new boolean[b-a+1];
		 * 
		 * for (int i = a; i <= b; i++) { if(i%2==0||i%5==0) { result[i-a] = true; }
		 * 
		 * }
		 */

		int a = 2;
		int b = 10;
		// int has 4 bytes in a 64 bit system
		// so 32 bits
		int result = 0;
		int size = (int)Math.ceil(((double)(b-a))/32);
		int[] resultArr = new int[size];

		for (int i = a; i <= b; i++) {
			if (i % 2 == 0 || i % 5 == 0) {
				resultArr = setBitArr(resultArr, i - a);
			}
		}

		System.out.println("MULTIPLES of 2 and 5:");
		for (int i = a; i <= b; i++) {
			if (getBitArr(resultArr, i - a)) {
				System.out.print(i + " ");
			}
		}
	}

	public static int setBit(int a, int index) {
		a = a | 1 << (index - 1);
		return a;
	}

	public static int clearBit(int a, int index) {
		a = a & ~(1 << (index - 1));
		return a;
	}

	public static int toggleBit(int a, int index) {
		a = a ^ 1 << (index - 1);
		return a;
	}

	public static boolean getBit(int a, int index) {
		a = a & 1 << (index - 1);
		if (a == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int[] setBitArr(int[] a, int index) {
		a[index >> 5] = a[index >> 5] | (1 << (index & 31));
		return a;
	}

	public static int[] clearBitArr(int[] a, int index) {
		a[index >> 5] = a[index >> 5] & ~(1 << (index & 31));
		return a;
	}

	public static int[] toggleBitArr(int[] a, int index) {
		a[index >> 5] = a[index >> 5] ^ (1 << (index & 31));
		return a;
	}

	public static boolean getBitArr(int[] a, int index) {
		int val = a[index >> 5] & (1 << (index & 31));
		if (val == 0) {
			return false;
		} else {
			return true;
		}
	}

}
