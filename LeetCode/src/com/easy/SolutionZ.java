package com.easy;

class SolutionZ {
	
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
    public static String convert(String s, int numRows) {
        
       StringBuffer out = new StringBuffer(); 
       StringBuffer[] str = new StringBuffer[numRows]; 
       for(int i=0; i< numRows; i++) {
           str[i] = new StringBuffer();
       }
        
      int row = 0;
      boolean flag = false;
      for(int i=0; i< s.length(); i++) {
           
    	 str[row].append(s.charAt(i));
    	 if(flag == true){
    		 row--;
    	 } else {
             row++; 
    	 }
         if(row>numRows-1) {
        	 flag = true;
        }
         if(row==0)
      }
        
    for(StringBuffer sb : str)  {
        
        out.append(sb);
    }  
        
    return out.toString();    
    
    }
}