package problems.fb;

public class Encrypt {
	public static void encryptHelper(String str, StringBuilder result) {

		if (str == "") {
			return;
		}
		if (str.length() == 1) {
			result.append(str.charAt(0));
			return;
		}
		int len = str.length();
		int mid = 0;
		if (len % 2 != 0) {
			mid = len / 2;
		} else {
			mid = len / 2 - 1;
		}
		result.append(str.charAt(mid));
		encryptHelper(str.substring(0, mid), result);
		encryptHelper(str.substring(mid + 1, len), result);
	}

	public static String findEncryptedWord(String s) {
		// Write your code here
		StringBuilder result = new StringBuilder();
		encryptHelper(s, result);
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(findEncryptedWord("abcd"));
	}

}
