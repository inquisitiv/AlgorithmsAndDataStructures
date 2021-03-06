package algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphNew {

	public HashMap<String, List<String>> map;
	int v; // count of vertices

	public GraphNew() {
		map = new HashMap<>();
	}

	public void addVertex(String vertex) {
		map.put(vertex, new ArrayList<>());
		v++;
	}

	public void addEdge(String source, String destination, boolean bidirectional) {

		if (!map.containsKey(source)) {
			map.put(source, new ArrayList<String>());
			v++;
		}

		if (!map.containsKey(destination)) {
			map.put(destination, new ArrayList<String>());
			v++;
		}

		map.get(source).add(destination);
		if (bidirectional) {
			map.get(destination).add(source);
		}

	}

	public int getVertexCount() {
		return map.keySet().size();
	}

	public int getEdgesCount(boolean birectional) {

		int count = 0;
		for (String v : map.keySet()) {
			count = count + map.get(v).size();
		}
		if (birectional) {
			count = count / 2;
		}
		return count;
	}

	public boolean hasVertex(String v) {
		return map.containsKey(v);
	}

	public boolean hasEdge(String s, String d) {

		if (map.containsKey(s)) {
			return map.get(s).contains(d);
		}
		return false;

	}

	public String toString() {

		StringBuilder str = new StringBuilder();
		for (String v : map.keySet()) {
			str.append(v).append(" : ");
			for (String connection : map.get(v)) {
				str.append(connection).append(" , ");
			}
			str.append("\n");
		}
		return str.toString();

	}

	public void DFS() {
		System.out.println();
		HashSet<String> visited = new HashSet<>();
		for (String v : map.keySet()) {
			if (!visited.contains(v)) {
			 DFSUtil(v, visited);
			}
		}
		System.out.println();

	}

	public void DFSUtil(String v, HashSet<String> visited) {
		if (!visited.contains(v)) {
			System.out.print(v + "->");
			visited.add(v);
			for (String conn : map.get(v)) {
				DFSUtil(conn, visited);
			}
		}
	}

	public void BFS() {
		System.out.println();
		HashSet<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		for (String v : map.keySet()) {
			if (!visited.contains(v)) {
				q.add(v);
				visited.add(v);
				while (!q.isEmpty()) {
					String temp = q.remove();
					System.out.print(temp + "->");
					for (String conn : map.get(temp)) {
						if (!visited.contains(conn)) {
							q.add(conn);
							visited.add(conn);
						}
					}
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		GraphNew graph = new GraphNew();
		graph.addEdge("a", "d", true);
		graph.addEdge("a", "b", true);
		graph.addEdge("b", "e", true);
		graph.addEdge("d", "e", true);
		graph.addEdge("b", "c", true);
		graph.addEdge("d", "c", true);
		graph.addEdge("d", "f", true);
		graph.addEdge("d", "h", true);
		graph.addEdge("f", "g", true);
		
		System.out.println(graph.toString());

		graph.BFS();
		graph.DFS();
	}
	
	public static boolean detectCycleUsing(GraphNew graph) {
		return false;
	}
	
	public static boolean detectCycleUsingUnionFind(GraphNew graph) {
		
	}
	
	public static void minSpanningTree(GraphNew graph) {
		//removeLoops();
		//removeParallelEdges();
		HashSet<String> visited = new HashSet<>();
	    HashMap<String,List<String>> edges = new HashMap<>();
		for(String v : graph.map.keySet()) {
			if(!visited.contains(v)) {
				for(String conn : graph.map.get(v)) {
					if(!edges.containsKey(v)) {
						edges.put(v,new ArrayList<String>());	
					} 
					List<String> edgeList = edges.get(v);
					edgeList.add(conn);
					
					
					
				}
				
			}
		}
		
		
	}

}
