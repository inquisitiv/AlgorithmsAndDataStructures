package problems.fb;

import java.util.*;

class Query {
	int type;
	int index;
	public Query(int type,int index ) {
		this.type = type;
		this.index = index;
	}
}
public class NearestTrue {

	public static ArrayList<Integer> applyQuery(ArrayList<Query> queries,int N) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Stack<Integer> s = new Stack<>();
		for(Query q : queries) {
			if(q.type==1) {
				pq.add(q.index);
			} else {
				while(!pq.isEmpty() && pq.peek()<q.index) {
					s.add(pq.remove());
				}
				if (pq.isEmpty()) {
					result.add(-1);
				}else if(pq.peek()>=q.index) {
					result.add(pq.peek());
				}
				while(!s.isEmpty()) {
					pq.add(s.pop());
				}
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		ArrayList<Query> list = new ArrayList<Query>();
		list.add(new Query(1,2));
		list.add(new Query(1,4));
		list.add(new Query(2,2));
		//list.add(new Query(1,3));
		list.add(new Query(2,3));
		System.out.println(applyQuery(list, 5).toString());
	}
	
	
	
	
	
}
