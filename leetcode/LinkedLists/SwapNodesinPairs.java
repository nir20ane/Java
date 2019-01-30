/*Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:
Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
** Approach: Swap two nodes and move pointers ahead
* Time Complexity: O(N)
* Space Complexity: O(1)
*/
package MyLinked;

public class SwapNodesinPairs {

    private Node head;
    
    public Node swappairs(Node head)
    {
    	Node dummy = new Node(0);  // create a dummy head
    	Node prev = dummy;
    	dummy.next = head;
    	while(prev.next != null && prev.next.next != null)
    	{
    		Node first = prev.next;
    	    Node second = prev.next.next;  // swap first and second nodes
    	    first.next = second.next;
    		prev.next = second;
    		prev.next.next = first;
    		prev = prev.next.next;  // skip two nodes at one time - important
    		
    	}
    	return dummy.next;
    }
    
	public static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		SwapNodesinPairs l1 = new SwapNodesinPairs();
        l1.head = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        Node n4 = new Node(7);
        Node n5 = new Node(8);
        Node n6 = new Node(4);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        Node nwll = l1.swappairs(l1.head);
        while(nwll != null)
        {
        	System.out.println(nwll.data);
        	nwll = nwll.next;
        }
	}

}
