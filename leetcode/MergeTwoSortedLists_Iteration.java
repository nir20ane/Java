/* Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4 
*** Approach: Iteration
* Time - O(n+m)
* Space - O(1), no extra space used
*/
package MyLinked;

public class MergeTwoSortedLists_Iteration {
    private Node head;
    
	public Node MergeTwoSortedLists_Iteration(Node l1, Node l2)
	{	
        Node prehead = new Node(-1);  // have a prehead node
        Node prev = prehead;
        while((l1 !=null) && (l2 != null))
        {
        	if(l1.data < l2.data)
        	{
        		prev.next = l1; // append l1 to list if l1 data is smaller
        		l1 = l1.next;
        	}
        	else
        	{
        		prev.next = l2; // append l2 to list if l2 data is smaller
        		l2 = l2.next;
        	}
        	prev = prev.next;
        }
        if(l1 == null) prev.next = l1;  // at this point there is one list with not null values
        if(l2 == null) prev.next = l2;  // append that list
        System.out.println(prehead.next.data);
        return prehead.next;  // return next of prehead
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
		MergeTwoSortedLists_Iteration l1 = new MergeTwoSortedLists_Iteration();
        l1.head = new Node(2);
        Node n2 = new Node(6);
        Node n3 = new Node(8);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = null;
        MergeTwoSortedLists_Iteration l2 = new MergeTwoSortedLists_Iteration();
        l2.head = new Node(1);
        Node n22 = new Node(3);
        Node n23 = new Node(4);
        l2.head.next = n22;
        n22.next = n23;
        n23.next = null;
        l1.MergeTwoSortedLists_Iteration(l1.head, l2.head);
        l1.MergeTwoSortedLists_Iteration(l1.head, l2.head);
        //System.out.println(l1.head.next.next.next.next.data);
        //System.out.println(l2.head.data);
	}
	

}

