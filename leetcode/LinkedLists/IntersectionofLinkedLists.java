/* Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.
** Approach: get the length of lists, adjust length to be equal, compare to find intersection
* Time O(n); Space O(1)
*/
package MyLinked;

public class IntersectionofLinkedLists {
	
	private Node head;
	
	public static class Node{  // class Node
		private int data;
		private Node next;
		Node(int data)
		{
			this.data = data;  // constructor Node
			this.next = null;
		}
	}
	
	public Node intersectiono(Node head1, Node head2)
	{
		int len1 = length(head1);  // length of head1 and length2
		int len2 = length(head2);
		
		while(len1 > len2)
		{
			head1 = head1.next;  // adjust length oh head1 if len1 is more
			len1--;
		}

		while(len2 > len1)
		{
			head2 = head2.next;  // adjust length oh head2 if len2 is more
			len2--;
		}

		while(head1 != head2)
		{
			head1 = head1.next;  // if nodes are not equal, keep incrementing
			head2 = head2.next;
		}
		return head1; // return intersecting node
	}
	
	public int length(Node node)  // length function
	{
		int count = 0;
		while(node != null)
		{
			node = node.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
        IntersectionofLinkedLists l1 = new IntersectionofLinkedLists();
		l1.head = new Node(4);
        Node n2 = new Node(1);
        Node n3 = new Node(8);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
		
        IntersectionofLinkedLists l2 = new IntersectionofLinkedLists();
        l2.head = new Node(5);
        Node n22 = new Node(1);
        Node n23 = new Node(0);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = n3;
        Node n = l1.intersectiono(l1.head, l2.head);
        System.out.println(n.data);
	}
}

