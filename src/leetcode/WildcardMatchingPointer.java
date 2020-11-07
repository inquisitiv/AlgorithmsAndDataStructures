package leetcode;


/*
 * 
 * "adceb"
 * "*a*b"
 * 
 */
public class WildcardMatchingPointer {
	
          public static void main(String[] args) {
			
        	  System.out.println(isMatch("adceb", "*a*b"));
        	  	
		  }
	
	
		   public static boolean isMatch(String s, String p) {
		        return isMatchR(s,p,s.length(),p.length());
		    }
		    
		    public static boolean isMatchR(String s, String p, int n, int m) {
		       System.out.println(s.substring(0, n));
		       System.out.println(p.substring(0, m));
		       System.out.println("-------------");
		    		   
		        if(m!=0) {
		            boolean isAllStar = true;
		            for(int k=0;k<m;k++){
		                if(p.charAt(k)!='*') {
		                    isAllStar = false;
		                    break;
		                }
		            }
		            if(isAllStar) {
		            return isAllStar;
		            }
		        }
		        
		        if(n==0 && m==0) {
		            return true;
		        } else if(n!=0 && m==0) {
		            return false;
		        } else if(n==0 && m!=0) {
		            boolean isAllStar = true;
		            for(int k=0;k<m;k++){
		                if(p.charAt(k)!='*') {
		                    isAllStar = false;
		                }
		            }
		            return isAllStar;
		        }
		        
		        
		        if(s.charAt(n-1) != p.charAt(m-1) && p.charAt(m-1)!='?'&& p.charAt(m-1)!='*') {
		            return false;
		        } else if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1)=='?') {
		            return isMatchR(s,p,n-1,m-1);
		        } else if(p.charAt(m-1)=='*') {
		            if(m-1>0) {
		                if(s.charAt(n-1)==p.charAt(m-2) || p.charAt(m-2)=='?') {
		                return isMatchR(s,p,n-1,m-2);
		                } else {
		                 return isMatchR(s,p,n-1,m);    
		                }
		            } else {
		                return true;
		            }
		        }
		    
		        return false;
		        
		        
		    }
		    
		
}
