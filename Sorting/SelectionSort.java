package sorting;

import java.util.Arrays;

class SelectionSort 
{ 
    void selctionsort(int arr[]) 
    { 
    	int n = arr.length;
       for(int i=0; i<n-1;i++)
       {
    	   int minindex = i;
    	   for(int j=i+1;j<n;j++)
    	   {
    		  if(arr[j] < arr[minindex]) 
    		  {
    			  minindex = j;
    		  }
    	   }
    	   int temp = arr[minindex];
    	   arr[minindex] = arr[i];
    	   arr[i] = temp;
       }
    } 

    public static void main(String args[]) 
    { 
        SelectionSort selsort = new SelectionSort(); 
        int arr[] = {64,25,12,0}; 
        System.out.println(Arrays.toString(arr));
        selsort.selctionsort(arr); 
        System.out.println(Arrays.toString(arr));
    } 
} 