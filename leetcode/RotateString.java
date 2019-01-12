/** We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true
Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:
** Contenate string str1+str1 and check if str2 is in str1
* Time Complexity - O(n^2)
* Space Complexity - O(n) - since we concatenate two strings
*/

public class RotateString{
	public boolean stringRotation(String str1, String str2)
	{
		// check for equal length and String str2 in concatenated str+str1
		return((str1.length() == str2.length()) && (str1+str1).contains(str2));
	}
	
	public static void main(String[] args)
	{
		RotateString strrot = new RotateString();
		System.out.println(strrot.stringRotation("bata", "taba"));
		System.out.println(strrot.stringRotation("bata", "tabe"));
	}
}
