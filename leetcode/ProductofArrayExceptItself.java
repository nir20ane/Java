/* Product of Array Except Self
Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
		
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space for the purpose of space complexity analysis.)
# Time Complexity: O(N)
# Space Complexity: O(N) if result array is considered, else O(1)
*/
package leetcodenew;

import java.util.Arrays;

public class ProductofArrayExceptItself {
	
	public int[] product(int[] nums)
	{
		int len = nums.length;
		int left = 1;
		int right = 1;
		int[] res = new int[len];
		for(int i=0;i<len;i++)
		{
			res[i] = 1;  // result array intialized to one
		}
		for(int i=0; i<len; i++)
		{
			res[i]*=left;
			left*=nums[i];  // product of left side elements
		}
		for(int i=len-1; i>=0; i--)
		{
			res[i]*=right;  // product of right side elements
			right*=nums[i];  // left side product*right side product gives intended result
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	public static void main(String[] args) {
		ProductofArrayExceptItself prod = new ProductofArrayExceptItself();
		int[] nums = {1, 2, 3, 4};
		prod.product(nums);
	}
}
