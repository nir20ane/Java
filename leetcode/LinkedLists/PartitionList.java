/*Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
** Approach: use before, before head, after, afterhead
* increment before and after based on node data
* join before.next and afterhead
* return before head
* Time complexity: O(N)
* Space Complexity: O(1)
*/
package MyLinked;

public class PartitionList {
	
	private static Node head;
	
	public static Node makepartition(Node head, int x)
	{
		Node beforehead = new Node(0);
		Node before = beforehead;
		Node afterhead = new Node(0);
		Node after = afterhead;
		while(head != null)
		{
			if(head.data< x)
			{
				before.next = head;
				before = before.next;  // add to before if val < x, increment before
			}
			else
			{
				after.next = head;
				after = after.next;  // add to after if val > x, increment after
			}
			head = head.next;
		}
		after.next = null;
		before.next = afterhead.next;  // join before and after
		return beforehead.next;  // return beforehead.next
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
		PartitionList l1 = new PartitionList();
        l1.head = new Node(1);
        Node n2 = new Node(0);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(2);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node part = l1.makepartition(l1.head,2);
        while(part != null)
        {
        	System.out.println(part.data);
        	part = part.next;
        }
	}
}
