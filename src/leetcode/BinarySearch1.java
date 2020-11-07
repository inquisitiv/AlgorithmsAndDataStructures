package leetcode;

import java.util.*;

import com.atlassian.ds.Collection;

public class BinarySearch1 {

	    public class Node {
	        public int val;
	        public int loc;
	    }
	    public List<Integer> countSmaller(int[] nums) {
	        List<Integer> list = new ArrayList<>();
	        int[] count = new int[nums.length];
	        PriorityQueue<Node> stack = new PriorityQueue<Node>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					if(o1.val>o2.val)
					    return 1;
					if(o1.val<o2.val)
						return -1;
					if(o1.val==o2.val)
						return 0;
				}
	        	
	        });
	        count[nums.length-1] = 0;
	        Node n = new Node();
	        n.val = nums[nums.length-1];
	        n.loc = nums.length-1;
	        stack.add(n);
	        for(int i = nums.length-2; i>=0; i--) {
	            while(!stack.isEmpty() && stack.peek().val>=nums[i]){
	                stack.remove();
	            }
	            if(!stack.isEmpty() && stack.peek().val<nums[i]){
	                count[i] = count[stack.peek().loc]+1;
	            }
	            n = new Node();
	            n.val = nums[i];
	            n.loc = i;
	            stack.add(n);
	            stack.add(n);
	        }
	        for(int x : count) {
	            list.add(x);
	        }
	        return list;
	        
	        
	    }
	    
	    public static void main(String[] args) {
			BinarySearch1 st = new BinarySearch1();
			System.out.println(st.countSmaller(new int[] {5,2,6,1}).toString());
		}
	
	
}
