/*Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: "cbbd"
Output: "bb"
*/
package leetcodenew;

public class LongestPalindromicSubstring {
	
	public String longpalindrome(String str)
	{
		int len = 0;
		int n = str.length();
		if(n<2) return str;
		int start = 0;
		int end = 0;
		for(int i=0;i<n;i++)
		{
			int len1 = expand(str, i, i);
			int len2 = expand(str, i, i+1);
			len = Math.max(len1, len2);
			if(len > end-start)
			{
				start = i-(len-1)/2;
				end = i+len/2;
			}
		}
		return str.substring(start, end+1);
	}
	
	public static int expand(String s, int L, int R)
	{
		while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R))
		{
			L--;
			R++;
		}
		return R-L-1;
	}
	public static void main(String[] args)
	{
		LongestPalindromicSubstring longpal = new LongestPalindromicSubstring();
		System.out.println(longpal.longpalindrome("cbbd"));
	}

}
