/*
In place sort: 
O(n**2) time complexity, O(1) space
each item in array, we have n swap
so n items * n swaps = O(n**2)
*/
package sorting;

import java.util.Arrays;

class InsertionSort 
{ 
    public void inssort(int[] arr)
    {
    	for(int i=1;i<arr.length;i++)
    	{
    		int j = i-1;
    		int key = arr[i];
    		while(j >= 0 && arr[j] > key)
    		{
    			arr[j+1] = arr[j];
    			j = j-1;
    		}
    		arr[j+1] = key;
    	}
    }
    public static void main(String[] args)
    {
    	InsertionSort insort = new InsertionSort();
    	int[] arr = {100000,4,0,-1,5,-9,3};
    	System.out.println(Arrays.toString(arr));
    	insort.inssort(arr);
    	System.out.println(Arrays.toString(arr));
    }
} 