package problems.aditya.recursion;

class WildCards {

	public static void main(String[] args) {

		 //System.out.println(isMatch("acdcb","a*c?b"));
		 //System.out.println(isMatch("", "*"));
		// System.out.println(isMatch("abced", "*a*b"));
		// System.out.println(isMatch("abefcdgiescdfimde","ab*cd?i*de"));
		// System.out.println(isMatch("aaaa","***a"));
		// System.out.println(isMatch("acdcb","a*c?b"));
		// System.out.println(isMatch("mississippi","m??*ss*?i*pi"));
		System.out.println(isMatch("ho", "ho**"));

	}

	public static boolean isMatch(String s, String p) {

		return firstMatch(s, 0, p, 0);

	}


	public static boolean firstMatch(String s, int start, String p, int pstart) {
		//System.out.println(s.substring(start));
		//System.out.println(p.substring(pstart));
		//System.out.println("-----------------");
		if (s.charAt(s.length()-1) != p.charAt(p.length()-1) || p.charAt(p.length()-1) != '?' && p.charAt(p.length()-1) != '*') {
			return false;
		} 
		if (pstart == p.length() - 1 && p.charAt(pstart) == '*') {
			return true;
		}
		if (pstart >= p.length() && start >= s.length()) {
			return true;
		}
		if (pstart >= p.length()) {
			return false;
		}
		if (start >= s.length()) {
			for(int i=pstart;i<p.length();i++) {
				if(p.charAt(i)!='*') {
					return false;
				}
			}
			return true;
		}
		if (s.charAt(start) == p.charAt(pstart) || p.charAt(pstart) == '?') {
			return firstMatch(s, start + 1, p, pstart + 1);
		} else if (p.charAt(pstart) == '*') {
			pstart++;
			while (pstart < p.length() && p.charAt(pstart) == '*') {
				pstart++;
			}
			return firstMatch(s, start, p, pstart) || firstMatch(s, start + 1, p, pstart)
					|| firstMatch(s, start+1, p, pstart-1);
		} else {
			return false;
		}

	}
}
