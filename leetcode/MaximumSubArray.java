/*Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/
package leetcodenew;

public class MaximumSubArray {
	
	public int maxsubarray(int[] nums)
	{
		int maxsofar = nums[0];
		int maxendinghere = nums[0];
		for(int i=0;i<nums.length;i++)
		{
			maxendinghere = Math.max(maxendinghere+nums[i], nums[i]);
			maxsofar = Math.max(maxsofar, maxendinghere);
		}
		
		return maxsofar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaximumSubArray maxsub = new MaximumSubArray();
		System.out.println(maxsub.maxsubarray(nums));
	}
}
