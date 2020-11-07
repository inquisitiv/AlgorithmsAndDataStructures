package problems.list;

public class SubstringByTwo {

	public static void main(String[] args) {
		
		String num = "1010100";
		int count = numberOfSubstring(num);
		System.out.println("No of substrings by 2 : "+count);
		
	}
	
    public static int numberOfSubstring(String num) {
		int count = 0;
		for(int i=0; i<num.length(); i++) {
			if(num.charAt(i) == '0') {
				System.out.println("i am at index " + i);
				count =  count + i + 1;
			}
		}
	   return count;
	}
	
}
