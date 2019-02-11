/*Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
package leetcodenew;

public class ReverseInteger {
	
	public int reverse(int x)
	{
		boolean negative = x<0;
		int reverse = 0;
		x = Math.abs(x);
		while(x != 0)
		{
			if(reverse > ((Integer.MAX_VALUE - (x%10))/10)) // check for reverse overflow
			{
				return 0;
			}
			reverse = reverse*10+(x%10);
			x = x/10;
		}
		if(negative == true) return -reverse;
		else return reverse;	
	}
	
	public static void main(String[] args) {
		ReverseInteger rev = new ReverseInteger();
		System.out.println(rev.reverse(123));
		System.out.println(rev.reverse(-123));
		System.out.println(rev.reverse(120));
		System.out.println(rev.reverse(1534236469));
	}
}
