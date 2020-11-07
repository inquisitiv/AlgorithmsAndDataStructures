package entities;

public class Node {

	public int data;
	public String info;
	public Node left;
	public Node right;
   
	public Node() {
		data = -1;
		left = null;
		right = null;
	}
	
	public Node(int val) {
		data = val;
		left = null;
		right = null;
	}
   
	/*public String toString() {
		return "[info:" + info + "," + " wt:" + data + "]";
	}*/
	public String toString() {
		return info;
	}
	
}
