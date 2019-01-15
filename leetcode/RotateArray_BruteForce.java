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

Approach: reverse entire array first, reverse first k elements, then reverse remaining array
Time Complexity O(n*k)
Space Complexity O(1)
*/

public class RotateArray_BruteForce {
    
	public void rotatearray(int[] arr, int k)
	{
		int last, temp;
		for(int i=0;i<k;i++)
		{
			last = arr[arr.length-1]; // store the last element before rotating
			for(int j=0;j<arr.length;j++)
			{
				temp = arr[j];
				arr[j] = last;
				last = temp;
				
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray_BruteForce rotseq = new RotateArray_BruteForce();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		rotseq.rotatearray(arr, 7);
	}

}
