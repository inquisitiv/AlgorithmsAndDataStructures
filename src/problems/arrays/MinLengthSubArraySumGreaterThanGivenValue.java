package problems.arrays;

public class MinLengthSubArraySumGreaterThanGivenValue {

	public static void main(String[] args) {
		int[] numbers = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		int sum = 280;
		int minLen = numbers.length;
		int curr_sum = 0;
		int startIndex = 0;
		for (int i = 0; i < numbers.length; i++) {

			curr_sum = curr_sum + numbers[i];
			if (curr_sum > sum && minLen > i - startIndex) {
				minLen = i - startIndex;
				while (curr_sum > sum) {
					curr_sum = curr_sum - numbers[startIndex];
					startIndex = startIndex + 1;
					if (curr_sum > sum && minLen > i - startIndex) {
						minLen = i - startIndex;
					}
				}
			}

		}
		minLen = minLen + 1;

		System.out.println("Minlength is: " + minLen);

	}

}
