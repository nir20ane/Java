import java.util.Arrays;
import java.util.HashMap;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
//Approach1: Use HashMap to store index of the number as value. if num is already a key in HashMap return index of target-num and num
public class Two_sum {
	public static int[] two_sum(int [] nums,int target)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)
		{
			if(map.containsKey(target-nums[i]))
			{
				return new int[] {map.get(target-nums[i]),i};
			}
			else
			{
				map.put(nums[i], i);
			}
		}
		return new int[] {};	
	}

	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(two_sum(nums,target)));
	}

}
