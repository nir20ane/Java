/* Queue data structure is implemented using circular arrays
 * The size of the Queue has to be mentioned before hand
 * Enqueue - inserts into queue - condition: queue full, queue empty, normal insert
 * Dequeue - removed from queue and returns element - conditions:only one element, queue empty, normal delete
 * isEmpty - returns true is queue is empty, false otherwise
 */
package mystack;

public class MyCircularQueue {
	
	int[] cqueue;
	int size;
	private int read = -1;
	private int write = -1;
	
	MyCircularQueue(int size)
	{
		cqueue = new int[size];
		this.size = size;
	}
	
	public void enqueue(int data)
	{
		if((write+1)%size == read) // queue is full cannot insert
		{
			System.out.println("Queue is Full cannot insert");
		}
		else if(read  == -1)  // queue is empty
		{
			read = 0;
			write = 0;
			cqueue[write] = data;
		}
		else
		{
			write = (write+1)%size;  // insert into non empty queue
			cqueue[write] = data;
		}
	}
	
	public int dequeue()
	{
		if(read == -1) // queue is empty
		{
			System.out.println("Queue is Empty");
			return -1;
		}
		else if(read == write)  // only one element in queue
		{
			int temp = cqueue[read];
			read = -1;
			write = -1;
			return temp;
		}
		else
		{
			int temp = cqueue[read];  // removes from queue
			read = (read+1)%size;
			return temp;
		}
	}
	
	public boolean isEmpty()
	{
		if(read == -1) return true;  // returns true if queue is empty
		else return false;
	}

	public static void main(String[] args) {
		MyCircularQueue mycq = new MyCircularQueue(20);
		mycq.enqueue(1);
		mycq.enqueue(2);
		mycq.enqueue(3);
		mycq.enqueue(4);
		mycq.enqueue(5);
		mycq.enqueue(6);
		mycq.enqueue(7);
		mycq.enqueue(8);
		mycq.enqueue(9);
		mycq.enqueue(10);
		mycq.enqueue(11);
		mycq.enqueue(12);
		mycq.enqueue(13);
		mycq.enqueue(14);
		mycq.enqueue(15);
		mycq.enqueue(16);
		mycq.enqueue(17);
		mycq.enqueue(18);
		mycq.enqueue(19);
		mycq.enqueue(20);
		mycq.enqueue(21);
		System.out.println(mycq.isEmpty());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());
		System.out.println(mycq.dequeue());		
		System.out.println(mycq.isEmpty());
	}
}
