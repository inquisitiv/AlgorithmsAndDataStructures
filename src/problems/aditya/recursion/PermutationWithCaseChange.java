package problems.aditya.recursion;

public class PermutationWithCaseChange {

	public static void main(String[] args) {
		String str = "ab3c";
		permutateWithCase(new StringBuffer(), new StringBuffer(str));
	}
	
	public static void permutateWithCase(StringBuffer output,StringBuffer input) {
		
		if(input.length() == 0) {
			System.out.println(output.toString());
			return;
		}
		
		int character = input.charAt(0);
		if (!Character.isDigit(character)) {
		char x = (char) character;
		char X = (char) (character-32);
		StringBuffer output1 = new StringBuffer(output);
		StringBuffer output2 = new StringBuffer(output);
		output1.append(x);
		output2.append(X);
		input = input.deleteCharAt(0);
		permutateWithCase(output1,new StringBuffer(input));
		permutateWithCase(output2,new StringBuffer(input));
		} else {
		 StringBuffer output1 = new StringBuffer(output);
		 output1.append((char) character);
		 input = input.deleteCharAt(0);
		 permutateWithCase(output1,new StringBuffer(input));
		}
		
		
		
	}
	
	
}
