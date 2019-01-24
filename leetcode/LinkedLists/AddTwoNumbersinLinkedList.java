/* Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/
package MyLinked;

public class AddTwoNumbersinLinkedList {
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
	
	public Node addtwonum(Node l1, Node l2)
	{
		int len1 = length(l1);
		int len2 = length(l2);
		
		Node dummy = new Node(1);  // make dummy as 1, so as to take care of carry afterwards
		dummy.next = len1 > len2? helper(l1, l2, len1-len2):helper(l2, l1, len2-len1);  // call helper to add two nums
		if(dummy.next.data > 9) //
		{
			dummy.next.data = dummy.next.data % 10;  // take care of first digit
			return dummy;  // return dummy
		}
		return dummy.next;  // if no carry return real head
	}
	
	public static Node helper(Node n, Node m, int offset)
	{
		if(n == null) return null;  // if list is null, return null
		
		Node result = offset == 0? new Node(n.data+m.data): new Node(n.data);  // calculate value at each position
		Node pos = offset == 0?helper(n.next, m.next, 0):helper(n.next, m , offset-1);  // recursive call to helper based on offset
		if(pos != null && (pos.data > 9))  // take care of carry here
		{
			pos.data = pos.data%10;
			result.data += 1;  // if carry, add 1 to result
		}
		result.next = pos;  // make new value as next
		return result;  // return node
	}
	
	public static int length(Node l)
	{
		int count  = 0;
		while(l != null)  // count and return number of nodes in list
		{
			count += 1;
			l = l.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		AddTwoNumbersinLinkedList l1 = new AddTwoNumbersinLinkedList();
		l1.head = new Node(7);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(3);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        
        AddTwoNumbersinLinkedList l2 = new AddTwoNumbersinLinkedList();
        l2.head = new Node(5);
        Node n22 = new Node(6);
        Node n23 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;

        System.out.println(l1.addtwonum(l1.head, l2.head).next.data);
	}
}
