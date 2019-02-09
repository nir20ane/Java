/*Given an array num of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.
Example:
Given array num = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
package leetcodenew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threesum(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i+2<nums.length;i++)
		{
			if(i>0 && nums[i] == nums[i-1]) continue;
			int j = i+1;
			int k = nums.length-1;
			int target = -nums[i];
			while(j<k)
			{
				if(nums[j] + nums[k] == target)
				{
					res.add(Arrays.asList(nums[j], nums[k], nums[i]));
					j++;
					k--;
					while(j<k && nums[j]==nums[j-1]) j++;
					while(j<k && nums[k]==nums[k+1]) k--;
				}
				else if(nums[j] + nums[k] > target)
				{
					k--;
				}
				else
				{
					j++;
				}
			}
		}
		return res;
	}
	
    public static void main(String[] args)
    {
    	ThreeSum threesum = new ThreeSum();
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	System.out.println(threesum.threesum(nums));
    }

}
