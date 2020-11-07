package problems.fb;

import java.util.*;

public class Dictionary {
	
	public static String make_valid(String s, String[] D) {
		
		HashSet<String> map = new HashSet<>();
		for(int i=0;i<D.length;i++) {
		   map.add(D[i]);
		}
		String str = "";
		makeValidUtil(s,map,s.length(),str);
		
		return str;
	}
	
	public static void makeValidUtil(String s,HashSet<String> map, int n, String str) {
		
		for(int i=1;i<=s.length();i++) {
			String prefix = s.substring(0,i);
			if(map.contains(prefix)) {
				if(i==n) {
					str = str+prefix;
					System.out.println(str);
					return;
				}
				makeValidUtil(s.substring(i, s.length()),map,s.length()-i,str + prefix + " ");
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(make_valid("whatisjava",new String[] {"what","i","is","java"}));
		//print("algorithms");
	}

	public static void print(String s) {
		
		if(s.length()<1) {
			return;
		}
		print(s.substring(1,s.length()));
		System.out.print(s.charAt(0));
		
	}
	
	
	
}
