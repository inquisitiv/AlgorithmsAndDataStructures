package topicwise.practice.backtracking;

class WM {
	
	public static void main(String[] args) {
		//System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("adceb","*a*b"));
	}
    
    public static boolean[][] t;
    public static boolean isMatch(String s, String p) {
        t = new boolean[s.length()+1][p.length()+1];
        /*for(int i=0;i<s.length()+1;i++) {
           Arrays.fill(t[i],-1);
        }*/
        String str = "....";
        str.charAt(i) = 'Q';
        
        return utility(s,p,0,0);
    }
    
    public static boolean utility(String s, String p, int start, int pStart) {
        
        /*if(pStart>=p.length() && start>=s.length()) {
            t[start][pStart] = 1;
            return true;
        } else if(pStart>=p.length() || start>=s.length()) {
            t[start][pStart] = 0;
            return false;
        }
       
        if(t[start][pStart]!=-1){
            if(t[start][pStart]==1){
                return true;
            } else {
                return false;
            }
        }
        if((s.charAt(start)==p.charAt(pStart) && utility(s,p,start+1,pStart+1))
         || ('*'==p.charAt(pStart) && utility(s,p,start+1,pStart+1))
          || ('*'==p.charAt(pStart) && utility(s,p,start+1,pStart)) 
          ||('*'==p.charAt(pStart) && utility(s,p,start,pStart)) 
          || ('?'==p.charAt(pStart) && utility(s,p,start+1,pStart+1))){
             t[start][pStart] = 1;
        } else {
             t[start][pStart] = 0;
        }
        if(t[start][pStart]==1){
                return true;
        } else {
                return false;
        }*/
        
        t[0][0] = true;
        for(int i=1;i<=s.length();i++){
        	 t[i][0] = false;
        }
        int count =0;
        for(int i=1;i<=p.length();i++){
           if(p.charAt(i-1)=='*'){
        	   count++;
           }
           if(count==i) {
        	   t[0][i]=true;
           } else {
               t[0][i]= false;
           }
        }
        
        for(int i=1;i<=s.length();i++){
        	for(int j=1;j<=p.length();j++){
        		char ch = s.charAt(i-1);
        		char ph = p.charAt(j-1);
        		if((ph=='*' && (t[i-1][j-1] || t[i][j-1] || t[i-1][j])) || (ph=='?' && t[i-1][j-1]) || (ph==ch && t[i-1][j-1])) {	
                    t[i][j] = true;
                } else {
                    t[i][j] = false;
                }
            } 
        }
        
        return t[s.length()][p.length()];
        
    }
    
}