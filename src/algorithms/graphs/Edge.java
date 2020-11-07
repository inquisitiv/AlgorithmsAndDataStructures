package algorithms.graphs;


public class Edge implements Comparable<Edge> {

	public int src;
	public int dest;
	public int weight;
	
	public Edge() {
		this.src = 0;
		this.dest = 0;
		this.weight = 0;
	}
	
	public Edge(int src,int dest,int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object o) {
		
		 if (o == this) { 
	            return true; 
	     } 
	  
		 if(!(o instanceof Edge)) {
			return false;
		 }
		
		 Edge c = (Edge) o; 
		 if((this.src == c.src && this.dest == c.dest && this.weight == c.weight) || (this.src == c.dest && this.dest == c.src && this.weight == c.weight)) {
			 return true;
		 } else {
			 return false;
		 }
	}
	
	@Override
	public int hashCode() {
		return this.weight*10000+this.dest*100+this.src;
	}
	
    @Override
    public int compareTo(Edge o) {
    	 if (o == this) { 
	            return 0; 
	     } 
	  
		 if(!(o instanceof Edge)) {
			return -1;
		 }
		
		 Edge c = (Edge) o; 
		 return Integer.compare(this.weight, c.weight);
    	
    }

	
	
}
