/**
Given a string, determine if a permutation of the string could form a palindrome.
Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Example 3:
Input: "carerac"
Output: true
 */
public class CanPermutePalindrome {
	
	public boolean canPermutePalindrome(String str)
	{
		int[] charmap = new int[128];
		int count = 0;
		for(int i=0;i<str.length();i++)
		{
			charmap[str.charAt(i)]++;
			if(charmap[str.charAt(i)] % 2 == 1) count++;
			else count--;
		}
		return count<=1;
	}
	
	public static void main(String[] args)
	{
		CanPermutePalindrome ispalper = new CanPermutePalindrome();
		System.out.println(ispalper.canPermutePalindrome("madam"));
		System.out.println(ispalper.canPermutePalindrome("actta Coa"));
	}
}