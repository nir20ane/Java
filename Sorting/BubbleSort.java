package sorting;

import java.util.Arrays;

public class BubbleSort {

	public void bubblesort(int[] arr)
	{
		int n = arr.length;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] arr = {90,-90,46,-600,23,45,129};
		System.out.println(Arrays.toString(arr));
		bs.bubblesort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
