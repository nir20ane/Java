/*Reverse a singly linked list - Iteration
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
Use Recursion, assume that the list is reverse after recursion and point to the element before
* time - O(n), space - O(n) - because of stack operations
*/package MyLinked;

public class ReverseLinkedList_Recursion {

	private Node head;
	
	public static class Node
	{
		private int data; // private data and next
		private Node next;
		public Node(int data)
		{
			this.data = data; // constructor for class Node
			this.next = next;
		}
	}
	
	public Node reverse(Node head)
	{
		Node curr = head;
		if(head==null || head.next == null) // return head if head or head.next is null
		{
			return head;
		}
		Node newnode = head.next;
		Node p = reverse(newnode);  // recursion on head.next
		newnode.next = head;  // reverse list to point to previous
		head.next = null;
	    System.out.println(p.data);
		return p;
	}
	
	public static void main(String[] args)
	{
		ReverseLinkedList_Recursion rll = new ReverseLinkedList_Recursion();
		rll.head = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		rll.head.next = n2;
		n2.next = n3;
		n3.next = null;
		rll.reverse(rll.head);
	}
}
