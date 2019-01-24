/*Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 
 */
package MyLinked;

public class DeleteNodefromList {
    
	private Node head;
	public void deletenode(Node node)
	{
		if(node.next != null)
		{
			node.data = node.next.data;  // if node.next is not null, delete node
			node.next = node.next.next;
		}
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
		DeleteNodefromList l1 = new DeleteNodefromList();
        l1.head = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(9);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        l1.deletenode(n2);
        System.out.println(l1.head.next.next.data);
	}

}
