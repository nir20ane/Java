package sorting;

import java.util.Arrays;

public class HeapSort 
{ 
    public void sort(int arr[]) 
    { 
        int n = arr.length;
        for(int i=(n-1)/2; i>=0; i--)
        {
        	heapify(arr,n,i);
        }
        System.out.println(Arrays.toString(arr));
        for(int i=n-1;i>=0;i--)
        {
        	int temp = arr[0];
        	arr[0] = arr[i];
        	arr[i] = temp;
        	// recursively heapify
        	heapify(arr,i,0);
        }
    } 

    void heapify(int arr[], int n, int i) 
    { 
        int largest = i;
        int l = (i*2)+1;
        int r = (i*2)+2;
        if(l<n && arr[l] > arr[largest])
        {
        	largest = l;
        }
        if(r<n && arr[r] > arr[largest])
        {
        	largest = r;
        }
        if(largest != i)
        {
        	int temp = arr[i];
        	arr[i] = arr[largest];
        	arr[largest] = temp;
        	// recursively heapify
            heapify(arr,n,largest);
        }
    } 

    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        HeapSort ob = new HeapSort(); 
        ob.sort(arr); 
        System.out.println(Arrays.toString(arr));
  } 
} 
