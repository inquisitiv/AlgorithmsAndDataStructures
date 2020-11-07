package problems.fb;

import java.util.HashMap;

public class Window {

	public static int minLengthSubstring(String s, String t) {
		// Write your code here
		Character c;
		HashMap<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			c = t.charAt(i);
			if (freq.keySet().contains(c)) {
				freq.put(c, freq.get(c) + 1);
			} else {
				freq.put(c, 1);
			}
		}
		HashMap<Character, Integer> currFreq = new HashMap<>();
		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE;
		int len = 0;
		int i = 0;

		c = s.charAt(i);
		while (!freq.keySet().contains(c)) {
			i++;
		}
		start = i;
		while (!freq.equals(currFreq) && i < s.length()) {
			c = s.charAt(i);
			if (freq.keySet().contains(c)) {
				if (currFreq.keySet().contains(c)) {
					currFreq.put(c, currFreq.get(c) + 1);
				} else {
					currFreq.put(c, 1);
				}
			}
			i++;
		}
		if (freq.equals(currFreq)) {
			end = i;
		}

		len = end - start;
		min = len;
		while (i < s.length()) {
			c = s.charAt(start);
			currFreq.put(c, currFreq.get(c) - 1);
			start = start + 1;
			i = end + 1;
			while (!freq.equals(currFreq) && i < s.length()) {
				c = s.charAt(i);
				if (freq.keySet().contains(c)) {
					if (currFreq.keySet().contains(c)) {
						currFreq.put(c, currFreq.get(c) + 1);
					} else {
						currFreq.put(c, 1);
					}
				}
				i++;
			}
			if (freq.equals(currFreq)) {
				end = i;
				len = end - start;
				if (len < min) {
					min = len;
				}
			}

		}

		return min;
	}

	public static void main(String[] args) {
		System.out.println(minLengthSubstring("dcbefebce", "fd"));
	}

}
