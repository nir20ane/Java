/*
* Next Permutation
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
* If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order)
* The replacement must be in-place and use only constant extra memory.
* Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column
* 1,2,3 -> 1,3,2
* 3,2,1 -> 1,2,3
* 1,1,5 -> 1,5,1
*/
package leetcodenew;

import java.util.Arrays;

public class NextPermutation {
	
	public int[] nextpermutation(int[] nums)
	{
		if(nums.length == 0 || nums == null) return nums;
		for(int i=nums.length-2; i>=0; i--)
		{
			if(nums[i] < nums[i+1])
			{
				
				for(int k=nums.length-1;i<k;k--)
				{
					if(nums[i] < nums[k])
					{
					int temp = nums[k];
					nums[k] = nums[i];
					nums[i] = temp;
					break;
					}
				}
				reverse(nums, i+1, nums.length-1);	
				return nums;
			}
		}
		reverse(nums, 0, nums.length-1);
		return nums;
	}
	
	public void reverse(int[] nums, int start, int end)
	{
		int i = start;
		int j = end;
		while(i <= j)
		{
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = {6,2,1,5,4,3,0};
		int[] nums1 = {3, 2, 1};
		int[] res = np.nextpermutation(nums);
		System.out.println(Arrays.toString(res));
		int[] res1 = np.nextpermutation(nums1);
		System.out.println(Arrays.toString(res1));
	}
}
