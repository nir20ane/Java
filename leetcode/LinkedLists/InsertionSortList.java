/*Sort a linked list using insertion sort.
A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
Algorithm of Insertion Sort:
Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.
Time Complexity- O(n^2) - because of comparisons and swaps
Space Compleity - O(1)
*/
package MyLinked;

public class InsertionSortList {
	private Node head;
    
	public Node sortlist(Node l)
	{
		Node prehead = new Node(0);
		Node prev = prehead;
		Node current = head;
		while(current != null)
		{
			prev = prehead;  // this is important prehead to be adjusted to dummy
			while(prev.next != null && prev.next.data < current.data)
			{
				prev = prev.next;   // this is important, adjust prev when samller value is found
			}
			Node next = current.next;
			current.next = prev.next;  // swapping
			prev.next = current;
			current = next;
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
		InsertionSortList l1 = new InsertionSortList();
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
