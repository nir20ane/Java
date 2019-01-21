/*Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.
Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
Approach:
1. Copy all elements to an array and return middle of the array, time O(n), space O(n)
2. Two runner, one slow and one fast, when fast runner reaches end, slow will be in the middle, time O(n), space O(1)
*/
package MyLinked;
public class MiddleofLinkedList{  
	
	Node head;
	
	public Node middle (Node head)
	{
		Node fast = head;  // two runners, fast and slow
		Node slow = head;
		while((fast!= null) && (fast.next!=null))
		{
			fast = fast.next.next; // fast pointer moves twice the speed of sloe
			slow = slow.next;
		}
		System.out.println(slow.data);
        return slow;  // return slow pointer
	}
	
	public static class Node {
        private int data;
        private Node next;  // class Node for data and next initialization
        //constructor
        public Node(int data) 
        { 
        	this.data = data; 
        	this.next = null; 
        }
    }

    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
    	MiddleofLinkedList llist = new MiddleofLinkedList();  // create linked list and try to add nodes
        llist.head  = new Node(1);
        Node second = new Node(2); 
        Node third  = new Node(3); 
        Node four  = new Node(4); 
        llist.head.next = second; 
        second.next = third; 
        third.next = four;
        llist.middle(llist.head);  // call middle method with head as parameter
    } 
} 