package com.easy;
import java.util.Stack;

public class Test {
	
	
	public static void main(String[] args) {
	
		
	    //System.out.println("\"" + reverseWords2("  hello world!  ") + "\"");
		System.out.println("\"" + trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}) + "\"");
		
	}
	
	public static String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        String[] array= s.split(" ");
        for(int i=array.length-1;i>=0;i--){
            String temp = array[i].trim();
            System.out.println("\"" + temp + "\"");
            if(!temp.equals("")) {
            if(i!=array.length-1) {    
            str.append(" " + temp.toString());
            } else {
                str.append(temp.toString());
            }
            }   
        }
        
        return str.toString();
    }
	
	public static String reverseWords2(String s) {
		StringBuffer str =  new StringBuffer();
        StringBuffer output =  new StringBuffer();
        Character temp;
        		
        for(int i=0;i<s.length();i++){
        	temp = s.charAt(i);
            if(temp != ' ') {
            	while(temp!=' ' ) {
            		str.append(temp);
            		i++;
            		if(i<s.length())
            		temp=s.charAt(i);
            	}
            	output.insert(0, str+" ");
            	str.setLength(0);
            }
        }
       
        return output.toString().trim();
    }
	
	 public static int trap(int[] height) {
	        
	        int area = 0;
	        for(int i=0;i<height.length-1;i++){
	            if (height[i]==0) {
	                continue;
	            }
	             for(int j=i+1;j<height.length;j++){
	                    while(height[j]<height[i] && j<height.length){
	                        area = area + (height[i]-height[j]);
	                        j++;
	                    }
	                    i=j-1;

	                }
	           }
	        
	        return area;
	        
	    }

}
