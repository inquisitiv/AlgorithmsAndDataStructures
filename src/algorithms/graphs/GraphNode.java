package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.Node;

public class GraphNode {
	
	public HashMap<Node, List<Node>> map;
	int v; // count of vertices

	public GraphNode() {
		map = new HashMap<>();
	}

	public void addVertex(Node vertex) {
		map.put(vertex, new ArrayList<>());
		v++;
	}

	public void addEdge(Node source, Node destination, boolean bidirectional) {

		if (!map.containsKey(source)) {
			map.put(source, new ArrayList<Node>());
			v++;
		}

		if (!map.containsKey(destination)) {
			map.put(destination, new ArrayList<Node>());
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
		for (Node v : map.keySet()) {
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
		for (Node v : map.keySet()) {
			str.append(v.toString()).append(" : ");
			for (Node connection : map.get(v)) {
				str.append(connection.toString()).append(" , ");
			}
			str.append("\n");
		}
		return str.toString();

	}

	public void DFS() {
		System.out.println();
		HashSet<Node> visited = new HashSet<>();
		for (Node v : map.keySet()) {
			DFSUtil(v, visited);
		}
		System.out.println();

	}

	public void DFSUtil(Node v, HashSet<Node> visited) {
		if (!visited.contains(v)) {
			System.out.print(v + "->");
			visited.add(v);
			for (Node conn : map.get(v)) {
				DFSUtil(conn, visited);
			}
		}
	}

	public void BFS() {
		System.out.println();
		HashSet<Node> visited = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		for (Node v : map.keySet()) {
			if (!visited.contains(v)) {
				q.add(v);
				visited.add(v);
				while (!q.isEmpty()) {
					Node temp = q.remove();
					System.out.print(temp + "->");
					for (Node conn : map.get(temp)) {
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
	
	
	public boolean isCyclePresent() {
		HashSet<Node> visited = new HashSet<Node>();
		HashMap<Node,Node> ds = new HashMap<>();
		for (Node v : map.keySet()) {
			ds.put(v,null);
		}
		System.out.println(ds.toString());
		for(Node vertex : map.keySet()) {
			for(Node connection : map.get(vertex)) {
				Node s1 = find(vertex, ds);
				Node s2 = find(connection, ds);
				visited.add(vertex);
				visited.add(connection);
				if(s1==s2) {
					return true;
				} else {
					ds.put(s1,s2);
					System.out.println(ds.toString());
				}
			}
		}
		return false;
		
	}

	
	public void union(Node src, Node dest, HashMap<Node,Node> ds) {
		Node set1 = find(src, ds);
		Node set2 = find(dest, ds);
		ds.put(set1,set2);
	}
	
	public Node find(Node ver, HashMap<Node,Node> ds) {
		Node setNode = ver;
		Node parent = ds.get(setNode);
		while(parent!=null) {
			setNode = parent;
			parent = ds.get(setNode);
		}
		return setNode;
	}

	public static void main(String[] args) {
		GraphNode graph = new GraphNode();
		Node a = new Node();
		a.info = "a";
		Node b = new Node();
		b.info = "b";
		Node c = new Node();
		c.info = "c";
		Node d = new Node();
		d.info = "d";
		Node e = new Node();
		e.info = "e";
		Node f = new Node();
		f.info = "f";
		Node g = new Node();
		g.info = "g";
		Node h = new Node();
		h.info = "h";
		
		graph.addEdge(a, d, true);
		graph.addEdge(a, b, true);
		//graph.addEdge(b, e, true);
		graph.addEdge(d, e, true);
		//graph.addEdge(b, c, true);
		graph.addEdge(d, c, true);
		graph.addEdge(d, f, true);
		graph.addEdge(d, h, true);
		graph.addEdge(f, g, true);
		
		System.out.println(graph.toString());

		graph.BFS();
		graph.DFS();
		//System.out.println(graph.isCyclePresent());
		floodFill(new int[][] {{1, 1, 0},{0, 0, 0},{0, 1, 0}}, 3);
	}
	
	public static void floodFill(int[][] arr, int n) {
	   int[][] visited = new int[n][n];	
	   int count = floodFillUtil(arr,0,0,n,visited);
	   System.out.println(count);	
		
	}
	
	public static int floodFillUtil(int[][] arr, int i, int j, int n, int[][] visited) {
        if(i<0 || i>=n || j<0 || j>=n) {
        	return 0;
        }
		if(arr[i][j]==1 && visited[i][j]!=1) {
    	   visited[i][j] = 1;
	       int count1 = floodFillUtil(arr, i+1,j,n,visited);
	       int count2 = floodFillUtil(arr, i-1,j,n, visited);
	       int count3 = floodFillUtil(arr, i,j+1,n,visited);
	       int count4 = floodFillUtil(arr, i,j-1,n,visited);
	       int count = count1+count2+count3+count4+1;
	       return count;
		} else {
			return 0;
		}
       
	}

}
