import java.util.Arrays;

/**Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
DO cyclic replacement of elements skipping k steps at a time
this is little complex, and done in place
Time Complexity - O(n)
Space Complexity - O(1)
*/
public class RotateArray_CyclicReplacement {
	
	public void rotate(int[] arr, int k)
	{   
		int count = 0;
		k = k%arr.length;
		for(int start=0; count<arr.length; start++)
		{   
			int current = start;
			int previous = arr[start];
			do
			{
				int next = (current+k)%arr.length;
				int temp = arr[next];
				arr[next] = previous;
				current = next;
				previous = temp;
				count += 1;
			}while(start != current);
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		RotateArray_CyclicReplacement rotarr = new RotateArray_CyclicReplacement();
		int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
		rotarr.rotate(arr, 3); 
	}
}