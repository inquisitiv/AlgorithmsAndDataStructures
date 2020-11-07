package algorithms.trees;

import entities.Node;

public class SeperateLinkedList {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 0;
		Node temp = head;
		temp.right = new Node(1);
		temp = temp.right;
		temp.right = new Node(2);
		temp = temp.right;
		temp.right = new Node(3);
		temp = temp.right;
		temp.right = new Node(4);
		temp = temp.right;
		temp.right = new Node(5);
		temp = temp.right;
		temp.right = new Node(6);
		temp = temp.right;
		temp.right = new Node(7);
		seperateEvenOdds(head);
		
		
		
		
	}
	public static void seperateEvenOdds(Node head) {
		// TODO Auto-generated method stub
		  
        Node even=null;
        Node evenPtr=null;
        Node odd=null;
        Node oddPtr=null;
        Node temp=null;
        
        temp = head;
        if(temp==null){
          return;
        }
	    if(temp.data%2!=0) {
	      Node x = temp;
	      temp = temp.right; 
	      oddPtr = x;
          oddPtr.right = null;
        } else {
          Node x = temp;
          temp = temp.right;
          even = x;
          evenPtr = x;
          evenPtr.right = null;
            
        }
        
        while(temp!=null){
           if(temp.data%2!=0) {
             Node x = temp;
             temp = temp.right;
             if(odd==null) {
               odd = x;
               oddPtr = x;
               oddPtr.right = null;
             }else {
            	 odd = x;
                 odd.right = oddPtr;
                 oddPtr = odd;
             }
           } else {
             Node x = temp;
             temp = temp.right;
             if(even==null) {
            	 even = x;
                 evenPtr = even;
             }else {
             evenPtr.right = x;
             evenPtr = evenPtr.right;
             evenPtr.right=null;
             }
           }
        }
        print(even);
        print(odd);
		
	}
	public static void print(Node head) {
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.right;
		}
		System.out.println();
	}
	
	
	
}
