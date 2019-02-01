/*Reverse Linked List II
Share
Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.
Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
* Approach:
* till m, increment pointer
* till n-m; do reverse, with tail = prev.next
* Time COmplexity : O(N)
* Space Complexity: O(1)
*/
package MyLinked;

public class ReverseLinkedListII {
	private  Node head;
	
	public static Node reversebetween(Node head, int m, int n)
	{
		Node dummy = new Node(0);
		Node prev = dummy;
		dummy.next = head;
		int i=0;
		while(i<m-1)
		{
			prev = prev.next;  // till m-1, increment prev
			i++;
		}
		Node tail = prev.next;  // make tail point to prev.next
		for(int j=0;j<n-m;j++)  // till n-m, do reverse
		{
			Node temp = prev.next;
			prev.next = tail.next;
			tail.next = tail.next.next;
			prev.next.next = temp;
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
		ReverseLinkedListII l1 = new ReverseLinkedListII();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node rev = l1.reversebetween(l1.head,2,4);
        while(rev != null)
        {
        	System.out.println(rev.data);
        	rev = rev.next;
        }
	}
}
