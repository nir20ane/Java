/* Linked List Cycle
* Given a linked list, determine if it has a cycle in it.
* To represent a cycle in the given linked list, 
* we use an integer pos which represents the position (0-indexed) in the linked list 
* where tail connects to. If pos is -1, then there is no cycle in the linked list.
* Approach: Time O(n); Space O(1)
*/
package MyLinked;

public class LinkedListCycle {
	
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
	
	public boolean cycledetect(Node head) {
		
		if(head == null || head.next == null) return false;  // check for proper head of list
		Node fast = head.next;  // fast and slow runners
		Node slow = head;
		while(slow != fast)
		{
			if(fast == null || fast.next == null) return false;  // if fast or fast.next never null, no loop
			slow = slow.next;
			fast = fast.next.next;  // increment fast and slow runners
		}
		
		return true;
	}

	public static void main(String[] args) {
		LinkedListCycle l1 = new LinkedListCycle();
        l1.head = new Node(2);
        Node n2 = new Node(6);
        Node n3 = new Node(8);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n2;
        LinkedListCycle l2 = new LinkedListCycle();
        l2.head = new Node(1);
        Node n22 = new Node(3);
        Node n23 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        System.out.println(l1.cycledetect(l1.head));
        System.out.println(l1.cycledetect(l2.head));
	}
}
