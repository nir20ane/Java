package myheap;

import java.util.Arrays;

public class MyHeap {
	
	static int capacity = 10;
	static int size = 0;
	static int[] items;
    
    public MyHeap() 
    { 
        items = new int[capacity];
    }
    
	private static int getleftchildindex(int parentindex)
	{
		return parentindex*2+1;
	}
	private static int getrightchildindex(int parentindex)
	{
		return parentindex*2+2;	
	}
	private static int getparentindex(int childindex)
	{
		return (childindex-1)/2;
	}
	private static boolean hasleftchild(int parentindex)
	{
		return getleftchildindex(parentindex) < size;
	}
	
	private static boolean hasrightchild(int parentindex)
	{
		return getrightchildindex(parentindex) < size;
	}
	
	private static boolean hasparent(int childindex)
	{
		return getparentindex(childindex) >= 0;
	}
	
	private static int leftchildvalue(int parentindex)
	{
		int index = getleftchildindex(parentindex);
		return items[index];
	}
	
	private int rightchildvalue(int parentindex)
	{
		int index = getrightchildindex(parentindex);
		return items[index];
	}
	
	private int parentvalue(int childindex)
	{
		int index = getparentindex(childindex);
		return items[index];
	}
	
	public void swap(int index1, int index2)
	{
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	
	public void ensurecapacity()
	{
		if(size == capacity)
		{
			items = Arrays.copyOf(items, capacity*2);
			capacity = capacity*2;
		}
	}
	
	public int peek()
	{
		if(size == 0)
		{
			throw new IllegalStateException("heap is empty!");
		}
		return items[0];
	}
	
	public int poll()
	{
		if(size == 0)
		{
			throw new IllegalStateException("heap is empty!");
		}
        int item = items[0];
        items[0] = items[size-1];
        heapifyDown();
        items[size-1] = 0;
        size-- ;
        return item;
	}
	
	public void additem(int item)
	{
		ensurecapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public void heapifyDown()
	{
		int index = 0;
		while(hasleftchild(index))
		{
			int smallchildindex = getleftchildindex(index);
			if(hasrightchild(index) && items[getrightchildindex(index)] < items[smallchildindex])
			{
				smallchildindex = getrightchildindex(index);
			}
			if(items[index] > items[smallchildindex])
			{
				swap(index, smallchildindex);
			}
			index = smallchildindex;
		}
	}
	
	public void heapifyUp()
	{
		int index = size-1;
		while(hasparent(index) && parentvalue(index) > items[index])
		{
			swap(getparentindex(index), index);
			index = getparentindex(index);
		}
	}
	
	   public void hprint() 
	    { 
		   System.out.println(Arrays.toString(items));
	    } 
	
	public static void main(String[] args) {
		MyHeap minheap = new MyHeap();
		minheap.additem(10);
		minheap.additem(15);
		minheap.additem(20);
		minheap.additem(17);
		minheap.additem(13);
		minheap.additem(7);
		minheap.hprint();
		System.out.println(minheap.poll());
		minheap.hprint();
		System.out.println(minheap.poll());
		minheap.hprint();
		System.out.println(minheap.poll());
		minheap.hprint();
		System.out.println(minheap.poll());
		minheap.hprint();
	}
}
