/* Rotate List
Given a linked list, rotate the list to the right by k places, where k is non-negative.
Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
** Approach: 
*/
package MyLinked;


public class RotateList {
	private static Node head;

	public static Node rotate(Node head, int k)
	{
		int l = 0;
		Node dummy = new Node(0);
		dummy.next = head;
		Node fast = dummy;
		Node slow = dummy;
		while(fast.next != null)
		{
			fast = fast.next;
			l++;
		}

		for(int j=l-k%l;j>0;j--)
		{
			slow = slow.next;
		}
		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;
		return dummy.next;
		
	}
	public static class Node {
        private int data;
        private Node next;  // class Node for data and next initialization
        public Node(int data) 
        { 
        	this.data = data; 
        	this.next = null; 
        }
    }

    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
    	RotateList rlist = new RotateList();  // create linked list and try to add nodes
        rlist.head  = new Node(1);
        Node second = new Node(2); 
        Node third  = new Node(3); 
        Node four  = new Node(4); 
        Node five  = new Node(5); 
        rlist.head.next  = second;
        second.next = third; 
        third.next = four;
        four.next = five;
        five.next = null;
        Node newnode = rlist.rotate(rlist.head, 2);  // call middle method with head as parameter
        while(newnode != null)
		{
        	System.out.println(newnode.data);
        	newnode = newnode.next;
		}
    } 

}
