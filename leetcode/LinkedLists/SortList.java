/*Sort a linked list in O(n log n) time using constant space complexity.
Example 1:
Input: 4->2->1->3
Output: 1->2->3->4
Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
** Approach: Merge Sort
* Time Complexity - O(nlogn)
* Space Complexity - Recursion, Stack Operations, O(n) time
*/
package MyLinked;

public class SortList {
	private Node head;
    
	public Node sortlist(Node l)
	{
	    if (l == null || l.next == null) return l;
		Node prev = null;
	    Node fast = l;
	    Node slow = l;

	    while(fast != null && fast.next != null)
	    {
	    	prev = slow;
	    	slow = slow.next;
	    	fast = fast.next.next;
	    }
	    
		prev.next = null;
		Node l1 = sortlist(l);
		Node l2 = sortlist(slow);
		
		return mergelist(l1, l2);
		
	}
	
	public static Node mergelist(Node l1, Node l2)
	{
		Node prehead = new Node(-1);
		Node prev = prehead;
				
	   while(l1 != null && l2 != null)
	   {
		   if(l1.data < l2.data)
		   {
			   prev.next = l1;
			   l1 = l1.next;
		   }
		   else
		   {
			   prev.next = l2;
			   l2 = l2.next;
		   }
           prev = prev.next;
	   }
	   if(l1 != null) prev.next = l1;
	   if(l2 != null) prev.next = l2;
	   return prehead.next;
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
		SortList l1 = new SortList();
        l1.head = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        Node n4 = new Node(7);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        Node nwll = l1.sortlist(l1.head);
        while(nwll != null)
        {
        	System.out.println(nwll.data);
        	nwll = nwll.next;
        }
	}
}
