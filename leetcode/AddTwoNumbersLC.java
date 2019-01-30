/*You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*** Approach: Elementary addition
** Time Complexity: O(max(m,n))
** Space Complexity: O(max(m,n))
*/
package MyLinked;

public class AddTwoNumbersLC {
	private Node head;
	
	public Node addtwonumbers(Node head1, Node head2)
	{
		Node dummy = new Node(0);
		Node p = head1;
		Node q = head2;
		Node curr = dummy;
		int carry = 0;
		int sum = 0;
		while(p != null || q != null)
		{
			int x, y;
			if(p != null) x = p.data;
			else x = 0;
			if(q != null) y = q.data;
			else y = 0;
			sum = carry + x + y;  // add node values and carry
			carry = sum/10;  // calculate carry
			curr.next = new Node(sum % 10);  // create addition node
			curr = curr.next;  // increment addition node
			if(p!= null) p = p.next;  // increment p and q till they are null
			if(q!= null) q = q.next;
		}
		if(carry > 0) curr.next = new Node(carry);
		while(dummy.next != null) 
		{
			System.out.println(dummy.next.data);
			dummy.next = dummy.next.next;
		}
		return dummy.next;
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
		AddTwoNumbersLC a = new AddTwoNumbersLC();
		AddTwoNumbersLC l1 = new AddTwoNumbersLC();
		l1.head = new Node(9);
        Node n2 = new Node(8);
        Node n3 = new Node(7);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = null;

        AddTwoNumbersLC l2 = new AddTwoNumbersLC();
        l2.head = new Node(4);
        Node n22 = new Node(7);
        Node n23 = new Node(7);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        a.addtwonumbers(l1.head, l2.head);
        
	}
}
