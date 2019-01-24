/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
** Approach: Use binary search
* Time Complexity - O(logn)
* Space Complexity - O(1)
*/
public class SearchinRotArray {
	
	public int search(int[] nums, int target)
	{
        if(nums.length < 1) { return -1;}  // corner cases are taken care here
        if(nums.length == 0 && (nums[0] == target)) {return 0; }
        if(nums.length == 0 && (nums[0] != target)) {return -1; } 
        
        int high = nums.length - 1; int low = 0;
        while(low <= high)
         {
        	 int mid = low + (high -low)/2;  // calculate mid
        	 if(nums[mid] == target) return mid;  // if mid == target, then return mid
        	 if(nums[low] <= nums[mid]){  
        		 if((nums[low] <= target) && (target <= nums[mid]))  high = mid -1;  // if target is between low and mid, adjust high
        		 else low = mid + 1;  // else adjust low
        	 } 
        	 else
        	 {
        	     if((nums[mid] <= target) && (target <= nums[high])) low = mid+1; // if target is between mid and high, adjust low
        	     else high = mid-1;  // else adjust high
        	 }
         }
        return -1;
	}

	public static void main(String[] args) {
       int[] nums = {4,5,6,7,0,1,2};
       int target = 0;
       SearchinRotArray searcht = new SearchinRotArray();
       System.out.println(searcht.search(nums, target));
       int[] nums1 = {1,2,4,5,6,7,0};
       System.out.println(searcht.search(nums1, target));
       int[] nums2 = {0,1,2,4,5,6,7};
       System.out.println(searcht.search(nums2, target));
	}

}
