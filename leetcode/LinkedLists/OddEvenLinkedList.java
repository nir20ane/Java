/*iven a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
** Approach: have odd, oddhead, even, even head
Time Complexity: O(n)
Space Compelxity: O(1) - no extra space is used
*/
package MyLinked;

public class OddEvenLinkedList {
    private Node head;

    private Node oddeven(Node head)
    {
    	Node even = head.next;  // have odd, even and even heads; odd head is head
        Node odd = head;
        Node evenh = even;
        while(even != null && even.next != null)
        {
        	odd.next = even.next;
        	odd = odd.next;
        	even.next = odd.next;
        	even = even.next;  // traverse through list to assign odd.next and even.next
        }
    	odd.next = evenh;  // join odd and even
    	return head;
    }
    
	public static class Node {
        private int data;
        private Node next;  // class Node for data and next initialization
        //constructor
        public Node(int data) 
        { 
        	this.data = data; 
        	this.next = null; 
        }
    }

    public static void main(String[] args) 
    { 
    	OddEvenLinkedList llist = new OddEvenLinkedList();  // create linked list and try to add nodes
        llist.head  = new Node(1);
        Node second = new Node(2); 
        Node third  = new Node(3); 
        Node four  = new Node(4); 
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        llist.head.next = second; 
        second.next = third; 
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = null;
        Node newl = llist.oddeven(llist.head);  // call oddeven method with head as parameter
        while(newl != null)
        {
        	System.out.println(newl.data);
        	newl = newl.next;
        }
    } 
}
