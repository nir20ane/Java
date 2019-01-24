/* Plus One Linked List
*Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
*You may assume the integer do not contain any leading zero, except the number 0 itself.
*The digits are stored such that the most significant digit is at the head of the list.
*Example :
*Input: [1,2,3]
*Output: [1,2,4]
* Approach: keep track of last digit that is less than 9, add 1 to it, increment, then add zeroes till end 
* Time : O(n); Space: O(1)
*/
package MyLinked;

public class PlusOneLinkedList {
	private Node head;
	
    public static class Node  // class Node
    {
	    private int data;
	    private Node next;
        Node(int data)  // constructor
        {
        	this.data = data;
        	this.next = null;
        }
    }
    
    public Node addone(Node head) {
    	
    	Node dummy = new Node(0);  // create dummy node
    	Node i = dummy;
    	Node j = dummy;
    	dummy.next = head;  // point it to head
    	
    	while(j != null)
    	{
    		if(j.data < 9) i = j;  // make last element less than 9 as i
    		j = j.next;
    	}
    	i.data = i.data + 1;  // increment i value
    	
    	j = i.next;  // move i
    	
    	while(j != null)
    	{
    		j.data = 0;  // add 0s till end
    		j = j.next;
    	}
    	
    	if(dummy.data == 0) return dummy.next;  // if dummy data is 0, retuen dummy next
    	return dummy;  // else return dummy
    }
    
    public static void main(String[] args) {
    	PlusOneLinkedList l1 = new PlusOneLinkedList();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(9);
        Node n4 = new Node(9);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        Node dummy = l1.addone(l1.head);
        System.out.println(dummy.data);
        System.out.println(dummy.next.data);
        System.out.println(dummy.next.next.data);
        System.out.println(dummy.next.next.next.data);
	}
}
