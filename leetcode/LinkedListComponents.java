/*Linked List Components
-> We are given head, the head node of a linked list containing unique integer values.
-> We are also given the list G, a subset of the values in the linked list.
-> Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
-> Example 1:
* Input:
* head: 0->1->2->3
* G = [0, 1, 3]
* Output: 2
* Explanation:
* 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
-> Example 2:
* Input:
* head: 0->1->2->3->4
* G = [0, 3, 1, 4]
* Output: 2
* Explanation:
* 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
-> Note:
* If N is the length of the linked list given by head, 1 <= N <= 10000.
* The value of each node in the linked list will be in the range [0, N - 1].
* 1 <= G.length <= 10000.
* G is a subset of all values in the linked list.
** Approach:
#traverse through linked list, if element in linked list is in subset list given,
#check if next value is null and next value not equal to current value, increment count
#return count
# Time: O(n); Space - O(1)
*/
package MyLinked;

import java.util.HashSet;

public class LinkedListComponents {
	
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
	
	public int countcomponent(Node next, int[] lst)
	{
		if(lst.length == 0) return 0;
		HashSet<Integer> set = new HashSet<Integer>();  // HashSet
		for(int l : lst)
		{
			set.add(l);  // add subset array values to set
		}
		Node curr = head;
		int count = 0;
		while(curr != null)  // while curr is not null
		{
			if(set.contains(curr.data) && (curr.next == null || !set.contains(curr.next.data))) // if value is set, and (next is not null or set does not contain next value)
			{
				count++;  // increment count
			}
			curr = curr.next;  // increment curr
		}
		return count;  // return count
	}
	
	public static void main(String[] args) {
		LinkedListComponents l1 = new LinkedListComponents();
		l1.head = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        int[] sub1 = {0, 1, 3};
        System.out.println(l1.countcomponent(l1.head, sub1));

        LinkedListComponents l2 = new LinkedListComponents();
        l2.head = new Node(0);
        Node n22 = new Node(1);
        Node n23 = new Node(2);
        Node n24 = new Node(3);
        Node n25 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
        n25.next = null;
        int[] sub2 = {0, 3, 1, 4};
        System.out.println(l2.countcomponent(l2.head, sub2));
	}

}
