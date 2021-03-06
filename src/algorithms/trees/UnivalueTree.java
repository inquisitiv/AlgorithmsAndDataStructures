package algorithms.trees;

import entities.Node;


/*
 *         0
 *      1     0
 *          1   0
 *        1   1      
 * 
 */
public class UnivalueTree {
	
	public static int totalCount = 0;
	
	public static void main(String[] args) {
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(1);
		root.right.left = new Node(1);
		root.right.right = new Node(1);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(1);
		System.out.println(isUnivalue(root));	
	}
	
	public static int isUnivalue(Node root) {
		
		utility(root);
		return totalCount;
		
	}
	
	public static int utility(Node node) {
		
		if(node!=null) {
		   if(node.left==null && node.right==null) {
			totalCount++;
			return node.data;
		   } else if(node.left==null || node.right==null){
			   return -1;
		   }
		}
		
		int left = utility(node.left); // 1
		int right = utility(node.right); // 
		if(left==-1 || right ==-1) {
			return -1;
		} else if(node.data==left && node.data==right) {
			totalCount++;
			return node.data;
		} else {
			return -1;
		}
		
	}
	

}
