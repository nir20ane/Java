/*Find Minimum in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
You may assume no duplicate exists in the array.

** Approach:
* Perform Binary search - return left most element
* time complexity is O(log n)
* space complexity is O(1)
*/

public class SearchMinSortArray {
	
	public int search(int[] nums){
		if(nums.length == 0) return -1;
		if(nums.length == 1)return nums[0];  // corner cases are taken care here
		int left = 0;
		int right = nums.length - 1;
		while(left < right)
		{
			int mid = left +(right-left)/2;  
			if(nums[mid] > nums[right]) left = mid+1; // adjust left if mid > right
			else right = mid; // else adjust right
		}
		
		return nums[left]; // return left most element
	}

	public static void main(String[] args) {
		SearchMinSortArray searchmin = new SearchMinSortArray();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minium element is : "+searchmin.search(nums));
	}
}