/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
** Approach: Use Priority Queue
** Time Complexity O(nlogk) k = is number of operations of PQ
** n is number of nodes in final list
** Space Complexity is O(n)
*/
package MyLinked;
import java.util.*;

public class MergeKSortedLists {
	private Node head;
	
	private static Node mergeklists(Node[] lists)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(lists.length);  // Priority Queue
		Node prehead = new Node(-1);
		Node curr = prehead;
		
		for(Node list: lists)
		{
			while(list != null)
			{
				pq.offer(list.data);  // insert every nodes from nodes[] in priority queue
				list = list.next;  
				
			}
		}
		
		while(! pq.isEmpty())
		{
			curr.next = new Node(pq.poll());  // poll priority queue until queue is empty
			curr = curr.next;                 // increment pointer
		}
		
		while(prehead.next != null)
		{
			System.out.println(prehead.next.data);  // print all sorted nodes
			prehead.next = prehead.next.next;
		}
		
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
		MergeKSortedLists l1 = new MergeKSortedLists();
        l1.head = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = null;
        
        MergeKSortedLists l2 = new MergeKSortedLists();
        l2.head = new Node(1);
        Node n22 = new Node(0);
        Node n23 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        
        MergeKSortedLists l3 = new MergeKSortedLists();
        l3.head = new Node(1);
        Node n223 = new Node(0);
        Node n33 = new Node(4);
        l3.head.next = n223;
        n223.next = n33;
        n33.next = null;
        Node[] lists = {l1.head, l2.head, l3.head};
        MergeKSortedLists.mergeklists(lists);

	}

}
