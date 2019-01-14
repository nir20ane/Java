/** Write a program to implement your own ArrayList class - Re-sizable Arrays
* It should contain add(), get(), remove(), size() methods. Use dynamic array logic.
* It should increase its size when it reaches threshold.
* **/
import java.util.Arrays;

public class MyArrayList {
	private static final int DEFAULT_CAPACITY = 10; // initial capacity
	private Object[] myArray = new Object[DEFAULT_CAPACITY]; // object creation
	private int count = 0; // count to keep track of number of objects inserted
	
	// get method will get object at index if it is a valid available index
	public Object get(int index)
	{
		if(index < count)
		{
		return myArray[index];
	    }
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	// add method will add object at end of ArrayList, if list size is close to capacity, then creates copy of array
	// with double the capacity
	public void add(Object obj)
	{
		//System.out.println("Array Length :"+myArray.length) ;
		if((myArray.length - count) <= 1)
		{
			increasecapacity();
		}
		myArray[count++] = obj;
		//System.out.println("Count "+count);
	}
	
	// this method returns actual count of objects in ArrayList
	public int size()
	{
		return count;
	}
	
	// This method doubles the capacity of ArrayList
	public void increasecapacity()
	{
		myArray = Arrays.copyOf(myArray, DEFAULT_CAPACITY*2);
	}
	
	// This method removes the element from a valid available index
	public Object remove(int index)
	{
		if(index < count)
		{
        
			Object obj = myArray[index];
			myArray[index] = null;
			while(index < count)
			{
				myArray[index] = myArray[index+1];
				myArray[index+1] = null;
				index++;
			}
			count--;
		    return obj;
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public static void main(String[] args)
	{
		MyArrayList myarray = new MyArrayList();
		myarray.add(2);
		myarray.add(5);
		myarray.add(1);
		myarray.add(23);
		myarray.add(14);
        for(int i=0;i<myarray.size();i++){
            System.out.print(myarray.get(i)+" ");
        }
        myarray.add(29);
        System.out.print("\n");
        System.out.println("Element at Index 5 : "+myarray.get(5));
        System.out.println("List size: "+myarray.size());
		myarray.add(12);
		myarray.add(15);
		myarray.add(19);
		myarray.add(78);
		myarray.add(92);
        for(int i=0;i<myarray.size();i++){
            System.out.print(myarray.get(i)+" ");
        }
        System.out.print("\n");
        System.out.println("List size: "+myarray.size());
        System.out.println("Removing element at index 2: "+myarray.remove(2));
        for(int i=0;i<myarray.size();i++){
            System.out.print(myarray.get(i)+" ");
        }
	}

}
