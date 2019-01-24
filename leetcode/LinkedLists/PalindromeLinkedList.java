/*Palindrome Linked List
* Given a singly linked list, determine if it is a palindrome.
* Example 1:
* Input: 1->2
* Output: false
* Example 2:
* Input: 1->2->2->1
* Output: true
** Approach: get middle of list, and then reverse one half, then compare the nodes
* Time - O(n); Space - O(1)
*/
package MyLinked;

public class PalindromeLinkedList {
    private Node head;
	
	    public static class Node  // class Node
	    {
		    private int data;
		    private Node next;
	        Node(int data)  // constructor
	        {
	        	this.data = data;
	        	this.next = null;
	        }
	    }
	    public boolean palindrome(Node head)
	    {
	    	Node fast = head;
	    	Node slow = head;  // fast and slow runners to get get middle
	    	while(fast != null && fast.next != null)
	    	{
	    		fast = fast.next.next;
	    		slow = slow.next;
	    	}
	    	
	    	if(fast != null)
	    	{
	    		slow = slow.next;  // adjust middle if length is odd
	    	}
	    	
	    	fast = head;  // update fast as head
	    	slow = reverse(slow);  // slow is reverse of slow
	    	
	    	while(slow != null)
	    	{
	    		if(slow.data != fast.data) return false; // compare nodes, if not equal return false
	    		slow = slow.next;
	    		fast = fast.next;  // increment fast and slow
	    	}
			return true;  // return true if same
	    }
	    
	    public Node reverse(Node head) {
	    	Node prev = null;  // reverse the list
	    	Node next = null;
	    	Node current = head;
	    	while(current != null)
	    	{
	    		next = current.next;
	    		current.next = prev;
	    		prev = current;
	    		current = next;
	    	}
	    	return prev;
	    }
	    
	    public static void main(String[] args) {
	    	PalindromeLinkedList l1 = new PalindromeLinkedList();
	        l1.head = new Node(1);
	        Node n2 = new Node(2);
	        Node n3 = new Node(2);
	        Node n4 = new Node(1);
	        l1.head.next = n2;
	        n2.next = n3;
	        n3.next = n4;
	        n4.next = null;
	        System.out.println(l1.palindrome(l1.head));
		}
}
