/* Implemenetd Doubly Linked List using Java
 * This has two pointers previous and next pointing to elements before and after
 * The operations implement include:
 * insertAtFront(element) - inserts element at beginning of list
 * insertAtEnd(element) - inserts element at end of list
 * size() - returns size of list
 * printlist() - prints elements of list in forward order
 * iterateFromFirst() - iterates list from front
 * iterateFromLast() - iterates list from back
 * removeFirst() - removes first element
 * removeLast() - removes last element
 * insertNth(int position, int data) - insert at a location
 * removeNth(int position) - remove from a location
 */

public class MyDoublyLinkedList {
    
	static Node head;
	static Node tail;
	static int size;
	
	MyDoublyLinkedList()
	{
        size = 0;  // constructor that initializes size as 0
	}
	
	static class Node
	{
		int element;  // static Node class for creating new nodes
		Node prev;
		Node next;
	
		Node(int element, Node prev, Node next){
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	}
	
	public void insertAtFront(int data)
	{
		Node newnode = new Node(data, null, head);  //inserts an element at beginning of list
		if(head != null) head.prev = newnode;  // next should be head
		head = newnode;
        if(tail == null) tail = newnode;
        size++;
	}
	
	public void insertAtEnd(int data)
	{
		Node newnode = new Node(data, tail, null);  // inserts an element at end of list
		if(tail != null) tail.next = newnode;  // prev should be tail
		tail = newnode;
		if(head == null) head = newnode;
		size++;
	}
	
	public void printlist()
	{
		if(size == 0) System.out.println("List is Empty");
		else
		{
			Node tmp = head;
			while(tmp != null)
			{
				System.out.print(tmp.element+" ");  //iterates from front and prints the list
				tmp = tmp.next;
			}
			System.out.println("");
		}
	}
	
	public void iterateFromFirst()
	{
		if(size == 0) System.out.println("List is Empty");
		else
		{
			Node tmp = head;
			int i =0;
			while(tmp != null)
			{
				System.out.println("Element at position "+i+" is : "+tmp.element);  //iterates from front and prints the list
				tmp = tmp.next;
				i = i+1;
			}
		}
	}
	
	public void removeFirst()
	{
		if(head == null) System.out.println("List is Empty");
		else
		{
			Node tmp = head;  // removes first element from non empty list
			head = tmp.next;
			head.prev = null;
			size--;
			System.out.println("Element removed is : "+tmp.element);
		}
	}
	
	public void removeLast()
	{
		if(head == null) System.out.println("List is Empty");
		else
		{
			Node tmp = tail;  // removes last element from non empty list
			tail = tmp.prev;
			tail.next = null;
			size--;
			System.out.println("Element removed is : "+tmp.element);
		}
	}
	
	public void iterateFromLast()
	{
		if(size == 0) System.out.println("List is Empty");
		else
		{
			Node tmp = tail;
			int i =size-1;
			while(tmp != null)
			{
				System.out.println("Element at position "+i+" is : "+tmp.element);  //iterates from last and prints the list
				tmp = tmp.prev;
				i = i-1;
			}
		}
	}
	
	public void removeNth(int position)
	{
	 if(position < 0 || position >= size) System.out.println("Not a valid position");
	 else
	 {
		 if(position == 0) removeFirst();  // Remove at Front if position is 0
		 else if(position == size-1) removeLast();  // Remove at last if position is equal to size of list
		 else
		 {
			 Node tmp = head;  // Remove at the position by iterating to the element
			 for(int i=0;i<position;i++)
			 {
				 tmp = tmp.next;
			 }
			 System.out.println("Element removed is : "+tmp.element);
			 tmp.prev.next = tmp.next;
			 //tmp.next = tmp.next.next;
			 size--;
			 
	     }
	 }
	}
	
	public void insertNth(int position,int element)
	{
	 if(position < 0 || position >= size) System.out.println("Not a valid position");
	 else
	 {
		 if(position == 0) insertAtFront(element);  // Insert at Front if position is 0
		 else if(position == size-1) insertAtEnd(element);  // Insert at last if position is equal to size of list
		 else
		 {
			 Node tmp = head;
			 for(int i=0;i<position;i++)
			 {
				 tmp = tmp.next; 
			 }
			 Node newnode = new Node(element, null, null);  // Insert at the position by iterating to the element
			 newnode.prev = tmp.prev;
			 tmp.prev.next = newnode;
			 newnode.next = tmp;
			 tmp.prev = newnode;
			 size++;
	     }
	 }
	}
	
	public int size()
	{	
		return size;  // returns size of list
	}
	
	public static void main(String[] args) {
		MyDoublyLinkedList mydll = new MyDoublyLinkedList();
		mydll.insertAtFront(20);
		mydll.insertAtFront(40);
		mydll.insertAtFront(80);
		mydll.insertAtEnd(30);
		mydll.insertAtEnd(50);
		mydll.insertAtEnd(70);
		System.out.println("Size of list is : "+mydll.size());
		mydll.printlist();
		mydll.iterateFromFirst();
		mydll.iterateFromLast();
		mydll.removeFirst();
		mydll.removeLast();
		System.out.println("Size of list is : "+mydll.size());
		mydll.printlist();
		mydll.removeNth(3);
		System.out.println("Size of list is : "+mydll.size());
		mydll.printlist();
		mydll.insertNth(1, 45);
		//mydll.insertNth(45, 1);
		System.out.println("Size of list is : "+mydll.size());
		mydll.printlist();
	}
}