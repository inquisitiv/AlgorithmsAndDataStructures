package algorithms.graphs;

import java.util.*;

public class TopologicalSort {
	
	
	public static void main(String[] args) {
		
		Graph<Integer> graph = new Graph<Integer>();
		
		graph.addVertex(5);
		graph.addVertex(4);
		graph.addVertex(0);
		graph.addVertex(2);
		graph.addVertex(1);
		graph.addVertex(3);
		
		graph.addEdge(5, 2, false);
		graph.addEdge(5, 0, false);
		graph.addEdge(4, 0, false);
		graph.addEdge(4, 1, false);
		graph.addEdge(2, 3, false);
		graph.addEdge(3, 1, false);
		
		topologicalsort(graph);
		
	}
	
	public static void topologicalsortUtil(Graph<Integer> graph,int vertex,boolean[] visited, Stack<Integer> stack) {
	
	  if(visited[vertex]== false) {
		visited[vertex] = true;
		
		for(int x : graph.map.get(vertex)) {
		    if(visited[x]== false) {
		    	topologicalsortUtil(graph,x,visited,stack);
		    }
		}
	   
	   stack.add(vertex);	
      }
		
	}
	
	public static void topologicalsort(Graph<Integer> graph) {
		
		int v = graph.getVertexCount();
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		
		
		for(Integer vertex : graph.map.keySet()) {
			topologicalsortUtil(graph, vertex,visited,stack);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
		
		
	}
	
	
}
