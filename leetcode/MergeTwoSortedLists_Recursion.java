/* Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4 
*** Approach: Recusrion
* Time - O(n+m)
* Space - O(n+m), n+m stack frames are consumed
*/
package MyLinked;

public class MergeTwoSortedLists_Recursion {
    private Node head;
    
	public Node MergeTwoSortedLists_Recursion(Node l1, Node l2)
	{	
		if(l1 == null) return l2;  // if l1 is null, return l2
		else if(l2 == null) return l1;  // if l2 is null, return l1
		else if(l1.data < l2.data)
		{
			l1.next = MergeTwoSortedLists_Recursion(l1.next, l2);  // l1 data is lesser than l2 data, pass l1.next and l2
			return l1;
		}
		else
		{
			l2.next = MergeTwoSortedLists_Recursion(l1, l2.next);  // l2 data is lesser than l1 data, pass l1 and l2.next
			return l2;
		}
	}
	
	public static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLists_Recursion l1 = new MergeTwoSortedLists_Recursion();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = null;
		MergeTwoSortedLists_Recursion l2 = new MergeTwoSortedLists_Recursion();
        l2.head = new Node(1);
        Node n22 = new Node(3);
        Node n23 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        l1.MergeTwoSortedLists_Recursion(l1.head, l2.head);
        l1.MergeTwoSortedLists_Recursion(l1.head, l2.head);
        System.out.println(l1.head.next.next.next.next.data);
        System.out.println(l2.head.data);
	}
}
