/* Stack data structure is implemented using linked list in java
 * Simple stack implementation to include following functions:
 * push(data) - pushes the element to top of stack
 * pop() - removes first element from stack and returns element if stack is not empty; if empty returns null
 * peek() - returns first element of non empty stack
 * isEmpty() - returns true is stack is empty, false otherwise
 * All these operations take O(1) time
 */
package mystack;

public class MyStack {
	private Node head;
    
	public class Node
	{
		int data;  // Node class
		Node next;
		Node(int data)  // Node constructor
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public int peek()
	{
		if(this.head == null)
		{
			return -1;
		}
		else
		{
			return this.head.data;  // returns head element from non empty stack
		}
	}
	public void push(int data)
	{
		Node newn = new Node(data);
		if(this.head == null)
		{
			this.head = newn;  // pushes the element to top of stack
		}
		else
		{
			newn.next = this.head;
			this.head = newn;
		}
	}
	
	public Node pop()
	{
		if(this.head == null)
		{
			return null;
		}
		else
		{
			Node temp = this.head;
			this.head = temp.next;  // removes and returns first element from non empty stack
			return temp;
		}
	}
	
	public boolean isEmpty()
	{
		if(this.head == null) return true;  // returns true if stack is empty, false otherwise
		else return false;
	}
	
	public static void main(String[] args)
	{
		MyStack stack1 = new MyStack();
		stack1.push(4);
		stack1.push(7);
		stack1.push(11);
		stack1.pop();
		stack1.pop();
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1.isEmpty());
		stack1.pop();
	}
}
