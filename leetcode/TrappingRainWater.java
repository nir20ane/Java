/*Trapping Rain Water
Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Thanks Marcos for contributing this image!
Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Time Complexity; O(n)
Space Complexity: O(1)
*/
package leetcodenew;

public class TrappingRainWater {
	
	public int trappedwater(int[] height)
	{
		int rainmax = 0;
		int lmax = 0;
		int rmax = 0;
		int a = 0;
		int b = height.length-1;
		while(a <= b)
		{
			lmax = Math.max(lmax, height[a]);
			rmax = Math.max(rmax, height[b]);  // calc lmax and rmax
			if(lmax < rmax)
			{
				rainmax += lmax - height[a];  // calc rain based on lower value - important
				a++;
			}
			else
			{
				rainmax += rmax - height[b];
				b--;
			}
		}
		return rainmax;  // return rainmax
	}
	
	public static void main(String[] args)
	{
		TrappingRainWater trap = new TrappingRainWater();
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(trap.trappedwater(height));
	}
}