package com.algorithm;

public class Palindrome {

	public boolean isPalindrome(String str) {
		
		if(str.length()<=1) {
			return true;
		}
		int len = str.length();
		for(int i=0;i<len/2;i++) {
			if(str.charAt(i)!= str.charAt(len-i-1)) {
				return false;
			}
		}
		
		return true;
	}

}
