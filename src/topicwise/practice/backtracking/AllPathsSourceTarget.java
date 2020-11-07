package topicwise.practice.backtracking;

import java.util.*;
// https://leetcode.com/problems/all-paths-from-source-to-target/

public class AllPathsSourceTarget {

	    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	        
	        HashSet<Integer> visited = new HashSet<Integer>();
	        List<List<Integer>> pathResult = new ArrayList<>();
	        List<Integer> path = new ArrayList<>();
	        path.add(0);
	        visited.add(1);
	        utility(graph, 0, path, pathResult, visited);  
	        return pathResult;
	    }
	    
	    public static void utility(int[][] graph, int index, List<Integer> path, List<List<Integer>> pathResult, HashSet<Integer> visited) {
	        
	        if(index>=graph.length-1){
	        	pathResult.add(path);
	            return;
	        }
	        
	        for(int child : graph[index]) {
	            if(!visited.contains(child)){
	                List<Integer> list = new ArrayList<Integer>(path);
	                //HashSet<Integer> visit = new HashSet<Integer>(visited);
	                list.add(child);
	                //visit.add(child);
	                utility(graph, child, list, pathResult, visited);  
	            }
	        }
	        
	        
	        
	    }
	    
	    public static void main(String[] args) {
			System.out.println(allPathsSourceTarget(new int[][] {{1,2},{3},{3},{}}));
	        System.out.println(allPathsSourceTarget(new int[][] {{4,3,1},{3,2,4},{3},{4},{}}));
		}
	
}
