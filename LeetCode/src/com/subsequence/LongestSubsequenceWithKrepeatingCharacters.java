package com.subsequence;

import java.util.Arrays;

public class LongestSubsequenceWithKrepeatingCharacters {

	
	public static void main(String[] args) {
		System.out.println("\"" + subsequence("abcabcbbdef", 1) + "\"");
	}
	
	public static String subsequence(String str,int k) {
		
		int[] freq = genereateFreq(str);
		int[] printedfreq = new int[256];
		Arrays.fill(printedfreq,0);
		StringBuffer strBuff = new StringBuffer();
	    int temp = 0;
		for(int i=0;i<str.length(); i++) {
			temp = str.charAt(i);
			if(freq[temp]>0 && printedfreq[temp]<k) {
			freq[temp]= freq[temp]-1; 
			printedfreq[temp] = printedfreq[temp]+1;
			strBuff.append(str.charAt(i));
			
			}
		}
		return strBuff.toString();
		
	}
	
	public static int[] genereateFreq(String str) {
		
		int[] freq = new int[256];
		Arrays.fill(freq,0);
	    int temp = 0;
		for(int i=0;i<str.length(); i++) {
			temp = str.charAt(i);
			freq[temp]= freq[temp]+1; 
		}
		
		return freq;
		
	}
	
}
