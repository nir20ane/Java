/*Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
package leetcodenew;

import java.util.HashMap;

public class LengthofLongestSubstring {
	
	public int lengthofstring(String str)
	{
		int n = str.length();
		int i =0;
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int j=0;j<n;j++)
		{
			if(map.containsKey(str.charAt(j)))
			{
				i = Math.max(map.get(str.charAt(j)), i);  // increment i, slide window if duplicate is window
			}
			
			map.put(str.charAt(j), j+1);   // store character and location with index starting from 1
			ans = Math.max(ans,  j-i+1);
		}
	   return ans;
	}

	public static void main(String[] args) {
		LengthofLongestSubstring len = new LengthofLongestSubstring();
		System.out.println(len.lengthofstring("abcabcbb"));
		System.out.println(len.lengthofstring("pwwkew"));
		System.out.println(len.lengthofstring("bbbbb"));
	}
}
