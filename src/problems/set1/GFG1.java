package problems.set1;

import java.util.*;
//paranthesis
class GFG1 {

	public static String parenthesisResult(String expression, HashMap<Character, Character> map) {

		if (expression.length() > 0) {
			Stack<Character> stack = new Stack<Character>();
			stack.push(expression.charAt(0));
			for (int i = 1; i < expression.length(); i++) {

				char ele = expression.charAt(i);
				if (!stack.isEmpty() && map.get(ele) != null && stack.peek() == map.get(ele)) {
					stack.pop();
				} else {
					stack.push(ele);
				}

			}
			if (stack.isEmpty()) {
				return "balanced";
			} else {
				return "not balanced";
			}
		}
		return "balanced";

	}

	public static void main(String[] args) {

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		// code
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		String expression;
		while (t > 0) {

			expression = input.nextLine();
			System.out.println(parenthesisResult(expression, map));
			t--;
		}
	}

}

//problem statement

/*Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced*/
