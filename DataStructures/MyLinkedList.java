/* Implementing a singly linked list in java
* Operations implemented include:
* insert(data) - Inserts data by creating a node
* insertAtFirst(data) - Inserts a node at head of list
* insertAtEnd(data) - Inserts a node at tail of list
* printlist() - Prints all elements in list
* insertBefore(data, beforedata) - Inserts node before data item provided
* insertAfter(data, afterdata) - Inserts node after data item provided
* findAt(location) - Prints the data at that location
* remove(data) - Will delete data element from list
* removeNth(Location) - Will delete element at this location
* removeAtFirst() - Removes First Element from List
* removeAtLast() - Removes Last Element from List
* isInList(data) - checks and true if given data element is present in list, returns false otherwise
*/

public class MyLinkedList{
	
	Node head; //head of the list
	private int count;
	
	static class Node{
		//inner class is made Static so that main can access it{ 
		private int data;
		private Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
		
	}
	public void insert(int data)
	{
		
		Node newnode = new Node(data);
		newnode.next = null;
		if(this.head == null) 
		{
			this.head = newnode; // insert at head if head is null
			this.count++;
		}
		else
		{
			Node last = this.head; // start from head and traverse till next != null
			while(last.next != null)last = last.next;
			last.next = newnode; // make the new node as last node
			this.count++;
		}
	}
	
       public void insertAtFirst(int data){
          Node newnode = new Node(data);
          if(this.head == null)
          {
    	      this.head = newnode;
    	      this.count++;
          }
          else
          {
    	      newnode.next = this.head;
    	      this.head = newnode;
    	      this.count++;
          }
	  }
	
	public void insertAtEnd(int data){
		
	      Node newnode = new Node(data);
	      if(this.head == null)
	      {
	    	  this.head = newnode;
	    	  this.count++;
	      }
	      else
	      {
	    	  Node last = this.head;
	    	  while(last.next != null)last = last.next;
	    	  last.next = newnode;	
	    	  this.count++;
	      }
	}
	
	public void printlist()
	{
		Node current = this.head;
		while(current != null)
		{
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.print("\n");
	}
	
	public void insertBefore(int data, int beforedata)
	{
		if (!isInList(beforedata)) System.out.println("Element is not present in the current list");
		else
		{
		Node newnode = new Node(data);
		newnode.next = null;
		Node current = this.head;
		if(beforedata == current.data)
		{
			insertAtFirst(data);
		}
		else
		{ 
			int i = 0;
			while(current.next != null)
			{
				if(current.data == beforedata)
				{
					break;
				}
				current = current.next;
				i++;
			}
			insertnth(data, i);
		}
		}
	}
	public void findAt(int location)
	{
		Node current = this.head;
		if(location <0 || location >= this.count) System.out.println("Not a valid location");
		else
		{
		    if(location == 0)System.out.println("Value at location 0 is :"+current.data);
		    else
		    {
		    int i = 0;
		    while(i <= location)
			{
			    if(i == location)
			     {
			        System.out.println("Data at location "+i+" is : "+current.data);
				break;
			      }
			     if(current.next != null) current = current.next;
			     i++;
			}
		    }
		}
		
	}
	public void insertAfter(int data, int afterdata)
	{
		if(!isInList(afterdata)) 
		{
		    System.out.print("Element is not present in current list"); 
		}
		else
		{
		    Node current = this.head;
		    Node newnode = new Node(data);
		    newnode.next = null;
		    int i=0;
		    while(current.next != null)
		    {
			if(current.data == afterdata) break;
			current = current.next;
			i++;
		    }
		    insertnth(data, i+1);
		}
	}
	
	public boolean isInList(int data)
	{
		if(this.head == null) return false;
		Node current = this.head;
		while(current.next != null)
		{
			if(current.data == data) return true;
			current = current.next;
		}
		return false;
	}
	
	
	public void insertnth(int data, int atposition)
	{

		if(atposition < 0 || atposition >= this.count) System.out.println("Not a valid position, size of list is : "+this.count);
		else
		{
		    Node newnode = new Node(data);
		    newnode.next = null;
		    if(atposition == 0) insertAtFirst(data);
		    else
			{
			    Node current = this.head;
			    for(int i = 1;i < atposition;i++)
				{
			            current = current.next;
				}
			     newnode.next = current.next;
			     current.next = newnode;
			     this.count++;
			}
		}
	}
	
	public void remove(int data)
	{
		if(!(isInList(data))) System.out.println("Element is not present in list");
		else
		{
			Node current = this.head;
			int i=0;
			while(current.next != null)
			{
			    if(current.data == data) break;
                            current = current.next;
			    i++;
			}
			removeNth(i+1);
			System.out.println("I value is :"+ i);
		}
	}
	
	public void removeNth(int position)
	{
		Node current = this.head;
		Node prevnode = null;
		if(position ==0) this.head = this.head.next;
		else
		{
		     for(int i=1; i<position; i++)
		     {
			prevnode = current;
			current = current.next;
		     }
		     prevnode.next = current.next;
		}
		this.count--;
	}
	
	public void removeAtFirst()
	{
		removeNth(0);
	}
	
	public void removeAtLast()
	{
		Node current = this.head;
		int i = 0;
		while(current.next != null)
		{
			current = current.next;
			i++;
		}
		removeNth(i+1);
	}
	
	public int size()
	{
		return this.count;
	}
	
	public static void main(String[] args)
	{
		MyLinkedList list = new MyLinkedList();
		list.insert(20);
		list.insert(30);
		list.insertAtFirst(10);
		list.insertAtEnd(100);
		list.printlist();
		list.insertnth(90, 10);
		list.insertnth(90, 0);
		list.printlist();
		//System.out.println("Size of list is : "+list.size());
		list.insertnth(80, 3);
		list.printlist();
		//System.out.println("Size of list is : "+list.size());
		System.out.println(list.isInList(10));
		list.insertBefore(56, 1000);
		//list.printlist();
		//System.out.println("Size of list is : "+list.size());
		list.insertBefore(56, 90);
		//System.out.println("Size of list is : "+list.size());
		//list.printlist();
		list.insertBefore(76, 20);
//		System.out.println("Size of list is : "+list.size());
//		list.printlist();
		list.insertAfter(96, 50);
//		System.out.println("Size of list is : "+list.size());
//		list.printlist();
		list.insertAfter(96, 10);
		System.out.println("Size of list is : "+list.size());
		list.printlist();
		list.remove(89);
		System.out.println("Size of list is : "+list.size());
		list.printlist();
		list.remove(30);
		System.out.println("Size of list is : "+list.size());
		list.printlist();
		list.removeAtFirst();
		System.out.println("Size of list is : "+list.size());
		list.printlist();
		list.removeAtLast();
		System.out.println("Size of list is : "+list.size());
		list.printlist();
		list.findAt(0);
		list.findAt(100);
		list.findAt(5);
	}
}
