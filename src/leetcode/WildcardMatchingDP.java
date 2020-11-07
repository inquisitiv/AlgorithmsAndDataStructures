package leetcode;

class WildcardMatchingDP {
    
    boolean[][] t;
    
    public boolean isMatch(String s, String p) {
        t = new boolean[s.length()+1][p.length()+1];
        return isMatchR(s,p,s.length(),p.length());
    }
    
    public boolean isMatchR(String s, String p, int n, int m) {
        
        for(int i=0;i<s.length()+1;i++) {
          for(int j=0;j<p.length()+1;j++) {
             if(i==0 && j==0){
                 t[i][j] = true;
             }else if(i!=0 && j==0) {
                 t[i][j] = false;
             }else if(i==0 && j!=0) {
                 boolean allStars = true;
                 for(int k=0;k<j;k++) {
                     if(p.charAt(k)!='*'){
                        allStars = false;
                     }
                 }
                 if(allStars == false) {
                     t[i][j] = false;
                 } else {
                     t[i][j] = true;
                 }
             }
                 
             }

           }
        
        for(int i=1;i<s.length()+1;i++) {
          for(int j=1;j<p.length()+1;j++) {
             if(s.charAt(i-1) != p.charAt(j-1) && p.charAt(j-1) != '?'&& p.charAt(j-1) != '*') {
              t[i][j] = false;
             } else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
              t[i][j] = t[i-1][j-1];
             } else if(p.charAt(j-1) == '*') {
                 
                 t[i][j] = t[i-1][j-1] || t[i-1][j] || t[i][j-1]; 
                 
             } else if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1) == '?') {
                 
                  t[i][j] = t[i-1][j] || t[i][j-1]; 
                                   
             }
              
              
          }
        }
                                  
        return t[n][m];                          
    
    
        
    }
    
}
