/* Given a sorted linked list, delete all duplicates such that each element appear only once.
* Example 1:
* Input: 1->1->2
* Output: 1->2
* Example 2:
* Input: 1->1->2->3->3
* Output: 1->2->3
*** Approach: if val == next.val, then remove the element, else increment head
*/
package MyLinked;

public class RemoveLinkedListElements {
private Node head;
	
	public static class Node
	{
		private int data;
		private Node next;
	    Node(int data)
	    {
	    	this.data = data;
	    	this.next = null;
	    }
	}
	
	public Node remove(Node head, int val)
	{
		while(head != null && head.data == val) head = head.next;  // check for head without duplicates
		Node current = head;  // update current to proper head
		while(current != null && current.next != null)
		{
			if(current.next.data == val) current.next = current.next.next;  // if data matches, remove element
			else current = current.next;  // else increment current
		}
		System.out.println(head.next.next.data);
		return head;
	}
	
	public static void main(String[] args) {
		RemoveLinkedListElements l1 = new RemoveLinkedListElements();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        Node n6 = new Node(5);
        Node n7 = new Node(6);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        l1.remove(l1.head, 6);
	}
}
