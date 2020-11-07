package problems.fb;

class Node {
	int data;
	Node next;

	Node(int x) {
		data = x;
		next = null;
	}
}

public class ReverseLinkedList {

	Node reverseHelper(Node curr) {
		Node start = curr;
		Node prev = null;
		Node next;
		while (curr != null && curr.data % 2 == 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		start.next = curr;
		return prev;
	} // Add any helper functions you may need here

	Node reverse(Node head) {

		// Write your code here
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			while (curr != null && curr.data % 2 != 0) {
				prev = curr;
				curr = curr.next;
			}
			if (curr != null && curr.data % 2 == 0) {
				if (prev != null) {
					prev.next = reverseHelper(curr);
				} else {
					head = reverseHelper(curr);
				}
				curr = curr.next;
			}
		}
		return head;
	}

	void print(Node head) {

		// Write your code here
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();

		Node head = new Node(1);

		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(6);
		head.next.next.next.next.next = new Node(5);

		obj.print(head);
		obj.reverse(head);
		obj.print(head);
	}

}
