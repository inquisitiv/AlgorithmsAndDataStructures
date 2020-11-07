package topicwise.practice.backtracking;

public class WildcardMatchingUsingDP {

	boolean[][] t;

	public boolean isMatch(String s, String p) {
		t = new boolean[s.length() + 1][p.length() + 1];
		return isMatchR(s, p, s.length(), p.length());
	}

	public boolean isMatchR(String s, String p, int n, int m) {

		t[0][0] = true;

		for (int i = 1; i < s.length() + 1; i++) {
			t[i][0] = false;
		}
		for (int j = 1; j < p.length() + 1; j++) {
			if (j == 1) {
				t[0][j] = p.charAt(0) == '*';
			}
			t[0][j] = p.charAt(j - 1) == '*' && t[0][j - 1];
		}

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				if (s.charAt(i - 1) != p.charAt(j - 1) && p.charAt(j - 1) != '?' && p.charAt(j - 1) != '*') {
					t[i][j] = false;
				} else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					t[i][j] = t[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {

					t[i][j] = t[i - 1][j - 1] || t[i - 1][j] || t[i][j - 1];

				}

			}
		}

		return t[n][m];

	}

}
