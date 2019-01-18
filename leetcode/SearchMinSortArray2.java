/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.
Example 1:
Input: [1,3,5]
Output: 1
Example 2:
Input: [2,2,2,0,1]
Output: 0
Note:
This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
** Approach: Use Binary Search
***** when mid == high, we don't know if minimum is in mid's left or right, so reduce right by one
*/
public class SearchMinSortArray2 {
	
	public int search(int[] nums) {
		
		if(nums.length == 0) return -1;
		if(nums.length == 1) return nums[0];  // corner cases
		
		int left = 0;
		int right = nums.length - 1;
		while(left <= right)   
		{
			int mid = left + (right - left)/2;  // calculate mid     
			if(nums[mid] > nums[right]) left = mid + 1;  // adjust left is minimum is on right of mid
			else if(nums[mid] < nums[right]) right = mid;  // adjust right is minimum is on left of mid
			else right -= 1;  // reduce right by 1, if right == mid
		}
		return nums[left];
	}
	

	public static void main(String[] args) {
		SearchMinSortArray2 serchmin = new SearchMinSortArray2();
		int[] nums = {1, 3, 5};
		int[] nums1 = {2, 2, 2, 0, 1};
		System.out.println(serchmin.search(nums));
		System.out.println(serchmin.search(nums1));
	}

}
