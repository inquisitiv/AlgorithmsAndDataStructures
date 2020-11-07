package algorithms.trees;

import java.util.*;

import entities.Node;

public class TreePractice {
	
	public static int pIndex = 0;

	public static void main(String[] args) {
		Node root = createTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10 });
//		Node root = createTree(new int[] { 10, 5, 20, 2, 8, 15, 25, -1, 3 });
//		levelOrderTraversal(root);
//		OrderTraversal(root);
//		funTraversals(root);
//		density(root);
//		postOrderFromInorderAndPreOder(new String[]{"8","4","9","2","5","1","6","3","7"}, new String[]{"1","2","4","8","9","5","3","6","7"});
//		findPath(root,5);
		
		//Lexico l = new Lexico();
		//System.out.println(l.smallestFromLeaf(root));
		//System.out.println(l.minCameraCover(root));
		
		//System.out.println(findLca(root,9,10).data);
		BFS(root);
		DFS(root);
	}

	public static Node createTree(int[] nums) {

		Node root = null;
		Node peek = null;
		Node temp = null;
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			temp = new Node(nums[i]);
			if (root == null) {
				root = temp;
				q.add(temp);
			} else {
				peek = q.peek();
				if (peek.left == null) {
					peek.left = temp;
					q.add(temp);
				} else {
					peek.right = temp;
					q.add(temp);
					q.remove();
				}
			}

		}
		q = null;
		return root;

	}

	public static void levelOrderTraversal(Node root) {

		if (root == null) {
			System.out.println("Tree is empty");
		}

		Queue<Node> q = new LinkedList<>();
		Node temp;
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp != null) {
				System.out.print(temp.data + "->");
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}

			} else {
				if (!q.isEmpty()) {
					q.add(null);
				}
				System.out.println();
			}
		}

	}

	public static void OrderTraversal(Node root) {

		if (root == null) {
			System.out.println("Empty Tree");
		}
		System.out.println("Inorder : ");
		inOrder(root);
		System.out.println();
		System.out.println("Preorder : ");
		preOrder(root);
		System.out.println();
		System.out.println("Postorder : ");
		postOrder(root);
		System.out.println();
		System.out.println("Inorder Iterative : ");
		inOrderIterative(root);
		System.out.println();
		System.out.println("Preorder Iterative : ");
		preOrderIterative(root);
		System.out.println();
		System.out.println("PostOrder Iterative 2 stack: ");
		postOrderIterativeTwoStack(root);
		System.out.println();
		System.out.println("PostOrder Iterative : ");
		postOrderIterative(root);
		System.out.println();
		

	}
	
	

	public static void inOrder(Node root) {

		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + "->");
		inOrder(root.right);

	}

	public static void preOrder(Node root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + "->");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static void postOrder(Node root) {

		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + "->");
	}

	public static void inOrderIterative(Node root) {

		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			System.out.print(temp.data + "->");
			temp = temp.right;
		}

	}

	public static void preOrderIterative(Node root) {

		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		stack.add(temp);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.data + "->");
			if (temp.right != null) {
				stack.add(temp.right);
			}
			if (temp.left != null) {
				stack.add(temp.left);
			}
		}
	}

	public static void postOrderIterativeTwoStack(Node root) {

		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Stack<Integer> result = new Stack<>();
		Node temp = root;
		stack.add(temp);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			result.add(temp.data);
			if (temp.left != null) {
				stack.add(temp.left);
			}
			if (temp.right != null) {
				stack.add(temp.right);
			}
		}
		while (!result.isEmpty()) {
			System.out.print(result.pop() + "->");
		}
	}

	public static void postOrderIterative(Node root) {
		if (root == null) {
			System.out.println("Stack is empty");
		}
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.add(temp);
				temp = temp.left;
			}
			temp = stack.peek();
			if (temp.right != null) {
				temp = temp.right;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + "->");
				while (!stack.isEmpty() && temp == stack.peek().right) {
					temp = stack.pop();
					System.out.print(temp.data + "->");
				}
				if (!stack.isEmpty()) {
					temp = stack.peek().right;
				} else {
					temp = null;
				}
			}
		}
	}
	
	public static void postOrderFromInorderAndPreOder(String[] inorder, String[] preorder) {
		
		System.out.println("What will be post order");
		postOrderFromInorderAndPreOderUtil(inorder, 0, inorder.length-1, preorder);
		
		
	}
	
	public static void postOrderFromInorderAndPreOderUtil(String[] inorder, int low, int high, String[] preorder) {
	
		
		if(low>high || pIndex>=preorder.length) {
			return;
		}
		String rootNode = preorder[pIndex++];
		int i = low;
		while(i<=high) {
			if(inorder[i]==rootNode) {
				postOrderFromInorderAndPreOderUtil(inorder,low,i-1,preorder);
				postOrderFromInorderAndPreOderUtil(inorder,i+1,high,preorder);
				System.out.print(rootNode+" ");
				return;
			}
			i++;
		}
		
		
	}
	
	
	public static void checkMirrorOfItself(Node node) {
		
		checkMirrorOfItselfUtil(node, node);		
		
	}
	
    public static boolean checkMirrorOfItselfUtil(Node node1, Node node2) {
		
		if(node1==null && node2 ==null) {
			return true;
		} 
		if(node1 != null && node2 != null) {
			return (node1.data == node2.data && checkMirrorOfItselfUtil(node1.left,node2.right) && checkMirrorOfItselfUtil(node1.right,node2.left));
		}
		return false;
		
	}
	
    public static void funTraversals(Node root) {

    	System.out.println("--Boundary Traversal--");
		boundaryTraversal(root);
		System.out.println();
    }
	
    public static void boundaryTraversal(Node root) {
    	if(root==null) {
    		System.out.println("Empty Tree");
    	}
    	System.out.print(root.data + "->");
    	printLeftNodesUpDown(root);
    	printRightNodesBottomUp(root);
    
    }
    
    public static void printLeftNodesUpDown(Node root) {
    	Node temp = root.left;
    	Stack<Node> stack = new Stack<Node>();
    	while(temp!=null) {
    		stack.push(temp);
    		System.out.print(temp.data + "->");
    		temp = temp.left;
    	}
    	while(!stack.isEmpty()) {
    		printAllLeafNodes(stack.pop().right);
    	}
    }
	 public static void printAllLeafNodes(Node node) {
		 
		 if(node == null) {
			 return;
		 }
		 if(node.left == null && node.right == null) {
			 System.out.print(node.data + "->");
		 }
		 printAllLeafNodes(node.left);
		 printAllLeafNodes(node.right);
	 	
	 }
	 public static void printRightNodesBottomUp(Node root) {
	 	
		 Stack<Node> stack = new Stack<Node>();
		 Node temp = root.right;
    	 while(temp!=null) {
    		stack.push(temp);
    		printAllLeafNodes(temp.left);
    		temp = temp.right;
    	 }
    	 while(!stack.isEmpty()) {
    		 System.out.print(stack.pop().data + "->");
    	 }
	 }
    
	 public static void density(Node root) {
		 
		Queue<Node>  q = new LinkedList<Node>();
		Node temp = root;
		q.add(temp);
		q.add(null);
		int size = 0;
		int height = 0;
		while(!q.isEmpty()) {
			temp = q.remove();
			if(temp == null && !q.isEmpty()) {
				height++;
				q.add(null);
			} else if(temp != null) {
				size++;
			
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
			}
			
		}
		
		System.out.println("Density : " + size/height);
		 
	 }
	 
	 public static void findPath(Node root, int ele) {
		 
		 System.out.println();
		 StringBuilder str = new StringBuilder();
		 boolean flag;
		 flag = hasPath(root, ele, str);
		 if(flag == true){
			 System.out.println("Path :" + str.toString());
		 } else {
			System.out.println("Not Found !"); 
		 }
	 }
	 
	 public static boolean hasPath(Node root, int ele, StringBuilder str) {
		
		 if(root == null) {
			 return false;
		 }
		 if(root.data == ele) {
			 System.out.println(str.toString());
			 return true;
		 }
		 str = str.append("->").append(root.data);
		 boolean flag;
		 flag =  hasPath(root.left,ele,str.append("->").append(root.data)) || hasPath(root.right,ele,str.append("->").append(root.data));
		 if(flag == true){
			 return true;
		 } else {
			 str.deleteCharAt(str.length()-1);
			 str.deleteCharAt(str.length()-1);
			 str.deleteCharAt(str.length()-1);
			 return false;
		 }
		 
	 }
	 
	 public static Node findLca(Node root, int n1, int n2) {
		 
		 if(root == null) {
			 return null;
		 }
		 if(root.data == n1 || root.data == n2) {
			 return root;
		 }
		 Node isInLeftTree = findLca(root.left, n1, n2);
		 Node isInRightTree = findLca(root.right, n1, n2);
		 
		 if(isInLeftTree!=null && isInRightTree!=null) {
			 return root;
		 } else if(isInLeftTree!=null){
			 return isInLeftTree;
		 } else if(isInRightTree!=null){
			 return isInRightTree;
		 } else {
			 return null;
		 }
		 
	 }
	 
     public static Node findLcaInBST(Node root, int n1, int n2) {
		 
		 if(root == null) {
			 return null;
		 }
		 if(root.data == n1 || root.data == n2) {
			 return root;
		 }
		 Node isInLeftTree = findLca(root.left, n1, n2);
		 Node isInRightTree = findLca(root.right, n1, n2);
		 
		 if(isInLeftTree!=null && isInRightTree!=null) {
			 return root;
		 } else if(isInLeftTree!=null){
			 return isInLeftTree;
		 } else if(isInRightTree!=null){
			 return isInRightTree;
		 } else {
			 return null;
		 }
		 
	 }
     
     public static void BFS(Node root) {
    	 
    	 System.out.println();
    	 if(root==null) {
    		 return;
    	 }
    	 Queue<Node> q = new LinkedList<Node>();
    	 q.add(root);
    	 while(!q.isEmpty()) {
    		
    		 Node temp = q.remove();
    		 System.out.print(temp.data+"->");
    		 if(temp.left!=null) {
    			 q.add(temp.left);
    		 }
    		 if(temp.right!=null) {
    			 q.add(temp.right); 
    		 }
    		 
    	 }
    	 System.out.println();
     }
     
     public static void DFS(Node root) {
    	 
    	 System.out.println();
    	 HashSet<Node> visited = new HashSet<>();
    	 DFSUtil(root,visited);
     }
     
     public static void DFSUtil(Node node, HashSet<Node> visited) {
    	 if(node!=null && !visited.contains(node)) {
    		 visited.add(node);
    		 System.out.print(node.data + "->");
    		 DFSUtil(node.left, visited);
    		 DFSUtil(node.right, visited);
    	 }	 
     }
	 
	 

}
