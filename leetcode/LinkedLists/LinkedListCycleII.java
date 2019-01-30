/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
Note: Do not modify the linked list.
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

** Approach: have two pointers, when slow is fast it means slow has completed a whole cycle
*  have another pointer slow2 as head, move slow2 and slow, when they intersect we will get the node at which cycle started
*  Time Complexity: O(N^2)
*  Space Complexity: O(n)
*/
package MyLinked;

public class LinkedListCycleII {
    private Node head;
    
    public Node cyclestart(Node head)
    {
    	Node fast = head;
    	Node slow = head;
    	while(fast.next !=null && fast.next.next != null)
    	{
    		fast = fast.next.next;
    		slow = slow.next;  // have two pointers, fast and slow
    		if(fast == slow)
    		{
    			Node slow2 = head;  // when they intersect have another pointer start from head
    			while(slow2 != slow)
    			{
    				slow = slow.next;
    				slow2 = slow2.next;  // slow2 and slow intersects we get the index at which cycle started
    			}
    			return slow;
    		}
    	}
    	return null;
    }
	
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
	public static void main(String[] args) {
		LinkedListCycleII l1 = new LinkedListCycleII();
        l1.head = new Node(2);
        Node n2 = new Node(6);
        Node n3 = new Node(8);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n2;
        LinkedListCycleII l2 = new LinkedListCycleII();
        l2.head = new Node(1);
        Node n22 = new Node(3);
        Node n23 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        System.out.println(l1.cyclestart(l1.head).data);
        System.out.println(l2.cyclestart(l2.head));
	}
}
