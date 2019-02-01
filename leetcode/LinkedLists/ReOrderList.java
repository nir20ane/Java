/*Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
** Approach: Split list into two, find Middle, reverse second half, and merge 1st and 2nd halves
*/
package MyLinked;

public class ReOrderList {
	private Node head;
    
	public void reorderList(Node head) {
		if(head == null && head.next == null) return ;
		Node fast = head, prev = null, slow = head, l1 = head;
		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
        prev.next = null;
        Node l2 = reverse(slow);
        merge(l1, l2);
	    }
	    
	public static Node reverse(Node head) {
          Node prev = null, next = null, curr = head;
          while(curr != null)
          {
        	  next = curr.next;
        	  curr.next = prev;
        	  prev = curr;
        	  curr = next;
          }
	      return prev;
	    }
	    
	public static void merge(Node l1, Node l2) {
	    while(l1 != null)
	      {
	        Node n1 = l1.next;
	        Node n2 = l2.next;
	        l1.next = l2;
	        if(n1 == null) break;
	        l2.next = n1;
	        l1 = n1;
	        l2 = n2;
	        }
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
		ReOrderList l1 = new ReOrderList();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        l1.reorderList(l1.head);
        while(l1.head != null)
        {
        	System.out.println(l1.head.data);
        	l1.head = l1.head.next;
        }
	}

}
