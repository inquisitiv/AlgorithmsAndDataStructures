package topicwise.practice.backtracking;

import java.util.HashMap;
import java.util.Map.Entry;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println("ADOBECODEBANC");
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String s, String t) {

		if (s.length() < t.length()) {
			return "";
		}

		String result = "";
		HashMap<Character, Integer> mapS = new HashMap<>();
		HashMap<Character, Integer> mapT = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			Character ch = t.charAt(i);
			if (!mapT.containsKey(ch)) {
				mapT.put(ch, 1);
			} else {
				int c = mapT.get(ch);
				mapT.put(ch, c + 1);
			}
		}

		int start = 0;
		while (start < s.length() && !mapT.containsKey(s.charAt(start))) {
			start++;
		}
		int i = start-1;
		while (start < s.length() && i < s.length()) {

			while (i < s.length()-1 && !checkEqual(mapT, mapS)) {
				    i++;
					Character ch = s.charAt(i);
					if (mapT.containsKey(ch)) {
						if (!mapS.containsKey(ch)) {
							mapS.put(ch, 1);
						} else {
							int c = mapS.get(ch);
							mapS.put(ch, c + 1);
						}
					}
					
				}
			    if(checkEqual(mapT, mapS)) {
				String str = s.substring(start, i + 1);
				//System.out.println(str);
				if (result.length() == 0 || str.length() < result.length()) {
					result = str;
				}
				Character ch = s.charAt(start);
				int c = mapS.get(ch);
				if (c <= 1) {
					mapS.remove(ch);
				} else {
					mapS.put(ch, c - 1);
				}
				start++;
				while (start < s.length() && !mapT.containsKey(s.charAt(start))) {
					start++;
				}
				i--;
			    }
			    i++;

		}

		return result;

	}

	public static boolean checkEqual(HashMap<Character, Integer> mapT, HashMap<Character, Integer> mapS) {

		if (mapT.keySet().equals(mapS.keySet())) {
			for (Entry<Character, Integer> x : mapT.entrySet()) {
				if (mapS.get(x.getKey()) < x.getValue()) {
					return false;
				}
			}
			return true;
		}
		return false;

	}

}
