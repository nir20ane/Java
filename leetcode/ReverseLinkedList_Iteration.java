/*Reverse a singly linked list - Iteration
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
Use iteration, store next element, make element point to previous, update previous to element we are sitting on now,
update current to next
* time - O(n), space - O(1)
*/
package MyLinked;

public class ReverseLinkedList_Iteration {
    private Node head;
    
    public Node reverse(Node head) {
    Node curr = head; // have variables to store head, prev and next
    Node prev = null;
    Node next = null;
    
    while(curr != null)
    {
    	next = curr.next;  // store next
    	curr.next = prev;  // reverse
    	prev = curr;       // assign prev and current
    	curr = next;
    }
    System.out.println(prev.data);
	return prev;  // return prev - head
    }
	public static class Node{
		private int data;  // class Node 
		private Node next;
		public Node(int data)  // constructor for class Node
		{
			this.data = data;
			this.next = next;
		}
	}
	public static void main(String[] args)
	{
		ReverseLinkedList_Iteration rll = new ReverseLinkedList_Iteration();
		rll.head = new Node(1);	
		Node n2 = new Node(2);
		rll.head.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		n3.next = null;
		rll.reverse(rll.head);  // reverse linked list
    }
}
