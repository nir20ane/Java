/** Split Linked List in Parts
* Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
* The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. 
* This may lead to some parts being null.
* The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
* Return a List of ListNode's representing the linked list parts that are formed.
* Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
* * Example 1:
Input: 
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
* Explanation:
* The input and each element of the output are ListNodes, not arrays.
* For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
* The first element output[0] has output[0].val = 1, output[0].next = null.
* The last element output[4] is null, but it's string representation as a ListNode is [].
* * Example 2:
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
* Explanation:
* The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
* Note:
* The length of root will be in the range [0, 1000].
* Each value of a node in the input will be an integer in the range [0, 999].
* k will be an integer in the range [1, 50].
* Time complexity = O(N+k)
* Space complexity = O(k)
*/
package MyLinked;

public class SplitLinkedListinParts {
	
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
    
    public Node[] split(Node root, int k) {
    	
    	int length = 0;
    	Node curr = root;
    	while(curr != null)
    	{
    		length++;
    		curr = curr.next;  // calculate length of linked list
    	}
    	int width = length/k;
    	int remain = length%k;  // width of reach part and remaining
    	
        Node[] split = new Node[k];
    	curr = root;
    	for(int i=0;i<k;++i)  // outer loop is k
    	{
    		Node head = curr;
    		for(int j=0; j< width+(i<remain?1:0)-1;++j)  // inner loop depends on remaining and i
    		{
    			if(curr != null) curr=curr.next;
    		}
    		if(curr !=  null)
    		{
    			Node prev = curr;  // make prev point to curr, increment curr
    			curr = curr.next;  // This is needed as head will now point to prev and the nodes following it
    			prev.next = null;  // incremented curr will become new head in next i iteration
    		}
    	    split[i] = head;
    	}
        return split;
    }

	public static void main(String[] args) {
		SplitLinkedListinParts l1 = new SplitLinkedListinParts();
	    l1.head = new Node(1);
	    Node n2 = new Node(2);
	    Node n3 = new Node(4);
	    Node n4 = new Node(9);
	    Node n5 = new Node(8);
	    l1.head.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
	    int k = 3;
	    Node[] split = l1.split(l1.head, k);
	    for(Node row: split)
	    {
	    	if(row != null)System.out.println(row.data);
	    }
        }
}
