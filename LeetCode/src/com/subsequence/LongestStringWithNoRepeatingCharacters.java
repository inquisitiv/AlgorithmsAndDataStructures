package com.subsequence;

import java.util.Arrays;

public class LongestStringWithNoRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println("\"" + lengthOfLongestSubstring("pwwkew") + "\"");
	}
	
	public static String substring(String str,int k) {
	
		 if(str.equals("")) {
				return "";
			}
			int[] printedfreq = new int[256];
			Arrays.fill(printedfreq,0);
		    int temp = 0;
		    int maxLen = Integer.MIN_VALUE;
		    int currLen = 0;
		    int start = -1;
		    int end = -1;
		    int startU = -1;
		    int endU = -1;
	        int i=0;
		    while(i<str.length()) {
		    	int j=i;
		    	temp = str.charAt(j);
		    	while(j<str.length() && printedfreq[temp]<k) {
		    		printedfreq[temp] = printedfreq[temp]+1;
		    		if(start == -1 || start>end){
		    			start = j;
		    			end = j;
		    		}
		    		j++;
		    		end++;
		    		if(j<str.length()) {
		    			temp = str.charAt(j);
		    		}
		    	}
		    	currLen = end-start+1;
		    	if(currLen>maxLen) {
		    		maxLen = currLen;
		    		startU = start;
		    		endU = end;
		    		
		    	}
		    	while(start<str.length() && j<str.length() && str.charAt(start)!= str.charAt(j) && start<end) {
		    		temp = str.charAt(start);
		    		printedfreq[temp] = printedfreq[temp]-1;
		    		start++;
		    		
		    	}
		    	if(start<str.length() && j<str.length() && str.charAt(start)== str.charAt(j) && start<end)              {
		    		start++;
		    		end++;
		    	    i=end;	
		    	}
		    	
		    }
	    
	    
		return str.substring(startU,endU+1);
		
	}
	
    public static int lengthOfLongestSubstring(String s) {
        int k =1;
        String str = s;
		 if(str.equals("")) {
				return 0;
			}
			int[] printedfreq = new int[256];
			Arrays.fill(printedfreq,-1);
		    int temp = 0;
		    int maxLen = Integer.MIN_VALUE;
		    int currLen = 0;
		    int start = -1;
		    int end = -1;
		    int startU = -1;
		    int endU = -1;
	        int i=0;
		    while(i<str.length()) {
		    	int j=i;
		    	temp = str.charAt(j);
		    	while(j<str.length() && printedfreq[temp]<=-1) {
		    		printedfreq[temp] = j;
		    		if(start == -1){
		    			start = j;
		    			end = j;
		    		}
		    		j++;
		    		end++;
		    		if(j<str.length()) {
		    			temp = str.charAt(j);
		    		}
		    	}
		    	currLen = end-start+1;
		    	if(currLen>maxLen) {
		    		maxLen = currLen;
		    		startU = start;
		    		endU = end;
		    		
		    	}
                if(j<str.length()){
		    	start = printedfreq[temp]+1;
                printedfreq[temp] = j;   
		        end = j;
		    	i=end+1;	
                }
		    	
		    	
		    }
        return endU-startU+1;
    }
}
