/* Remove Duplicates from Sorted List
* Given a sorted linked list, delete all duplicates such that each element appear only once.
* Example 1:
* Input: 1->1->2
* Output: 1->2
* Example 2:
* Input: 1->1->2->3->3
* Output: 1->2->3
* Approach:
* Time - O(n); Space O(1) - Traverse through list and remove duplicates
*/
package MyLinked;

public class RemoveDuplicatesfromSortedList {
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
	
	public Node remove(Node head)
	{
		Node curr = head;
		while(curr != null && curr.next != null)  // Traverse through list
		{
			if(curr.data == curr.next.data)
			{
				curr.next = curr.next.next;  // if there is duplicate, remove element
			}
			else
			{
				curr = curr.next;  // else increment current
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList l1 = new RemoveDuplicatesfromSortedList();
        l1.head = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(8);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = null;
        RemoveDuplicatesfromSortedList l2 = new RemoveDuplicatesfromSortedList();
        l2.head = new Node(1);
        Node n22 = new Node(1);
        Node n23 = new Node(3);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        System.out.println(l1.remove(l1.head).next.data);
        System.out.println(l2.remove(l2.head).next.data);
	}
}
