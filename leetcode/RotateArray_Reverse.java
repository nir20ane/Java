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

** Approach: Using reverse
Time Complexity - O(n)
Space Complexity - O(1)
*/

public class RotateArray_Reverse {
	
	public void rotate(int[] nums, int k)
	{
		k = k%nums.length;
		reverse(nums, 0, nums.length-1);  // perform reverse operation on whole array
		//System.out.println(Arrays.toString(nums));
		reverse(nums, 0, k-1);            // perform reverse operation from 0 to k-1
		//System.out.println(Arrays.toString(nums));
		reverse(nums, k, nums.length-1);  // perform reverse operation from k till end of array
		System.out.println(Arrays.toString(nums));
	}
    public void reverse(int[] nums, int start, int end)
    {
    	while(start < end)
    	{
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		end--;
    		start++;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RotateArray_Reverse rotarr = new RotateArray_Reverse();
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    rotarr.rotate(arr, 3);
	}

}
