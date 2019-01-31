/*Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.
Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Follow up:
Could you do this in one pass?
** Approach: one pass, first till n, then move first and second till end,
* that way difference between first and second is always n
* time complexity: O(n)
* space complexity: O(1) 
*/
package MyLinked;

public class RemoveNthNodefromList {
    private Node head;
    
    public Node removefromend(Node head, int n)
    {
    	Node dummy = new Node(0);
    	Node first = dummy;
    	Node second = dummy;
    	dummy.next = head;
    	int i=0;
    	while(i <= n)
    	{
    		first = first.next;  // increment first till n
    		i++;
    	}
    	while(first != null)
    	{
    		first = first.next;  // increment first and second till end; so that diff is always n nodes
    		second = second.next;
    	}
    	second.next = second.next.next;  // remove nth from last node
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
		RemoveNthNodefromList l1 = new RemoveNthNodefromList();
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
        Node nwll = l1.removefromend(l1.head, 4);
        while(nwll != null)
        {
        	System.out.println(nwll.data);
        	nwll = nwll.next;
        }
	}
}
