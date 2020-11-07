package com.easy;

import java.util.*;

public class Solution2 {
	
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}
public static List<List<String>> groupAnagrams(String[] strs) {
	
	StringBuffer str = new StringBuffer();
	str.setl
        
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        int[] hashArray = new int[26];
        
        for(int i=0;i<strs.length;i++){
      
                Arrays.fill(hashArray,0);
                for(int j=0;j<strs[i].length();j++){
                int temp = strs[i].charAt(j)-97;
                hashArray[temp] = hashArray[temp]+1;
                }
                String key = Arrays.toString(hashArray);
               if (!map.containsKey(key)) {
                   List<String> list = new ArrayList<String>();
                   list.add(strs[i]);
                   map.put(key,list);
               } else {
                   map.get(key).add(strs[i]);
               }
            
        }
        return new ArrayList<List<String>>(map.values());
        
    }
}
