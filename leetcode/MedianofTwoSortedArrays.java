/*4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
*/
package leetcodenew;

public class MedianofTwoSortedArrays {
	
	public int median(int[] nums1, int[] nums2)
	{
		int m = nums1.length;
		int n = nums2.length;
		if(m > n)
		{

			int[] temp = nums1;
			nums1 =  nums2;
			nums2 = temp;
			m = nums2.length;
			n = nums1.length;
		}
		if(n == 0) return -1;
		int imin = 0;
		int imax = m;
		int halflen = (m+n+1)/2;
		while(imin <= imax)
		{
			int i = (imin+imax)/2;

			int j = halflen -i;
			
			if(i>1 && i<m && (nums2[j-1] > nums1[i]))
			{
				System.out.println("yes");
				imin = i+1;
			}
			else if(i>0 && (nums1[i-1] > nums2[j]))
			{
				imax = i-1;
			}
			else
			{
				int maxleft;
				if(i == 0) maxleft =nums2[j-1];
				else if(j == 0) maxleft = nums1[i-1];
				else maxleft = Math.max(nums2[j-1], nums1[i-1]);
				
				if((m+n)/2 == 1)
				{
					return maxleft;
				}
				
				int minright;
				if(i==m) minright = nums2[j];
				else if(j==n) minright = nums2[i];
				else minright = Math.min(nums2[j], nums1[i]);
				return maxleft+minright/2;  // i is found
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		MedianofTwoSortedArrays med = new MedianofTwoSortedArrays();
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println(med.median(nums1, nums2));
		int[] nums3 = {1, 2};
		int[] nums4 = {1, 4};
		System.out.println(med.median(nums3, nums4));
	}
}
