/* Palindrome Number
* Determine whether an integer is a palindrome. 
* An integer is a palindrome when it reads the same backward as forward.

* Example 1:
* Input: 121
* Output: true
* Example 2:
* Input: -121
* Output: false
* Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
* Example 3:
* Input: 10
* Output: false
* Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
* Reverse the number first and check if it is equal to original number
*/
package leetcodenew;

public class PalindromeNumber {
	
	public boolean palinnumber(int num)
	{
		if(num < 0) return false;
		if(num == 0) return true;
		if(num%10 == 0) return false;
		int y = num;
		int rev = 0;
		while(y != 0)
		{
			rev = rev*10+(y%10);
			y = y/10;
		}
		return num==rev;
	}
	
	public static void main(String[] args)
	{
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.palinnumber(121));
		System.out.println(pn.palinnumber(10));
	}
}
