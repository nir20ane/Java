/*
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *  Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
package leetcodenew;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public boolean wordbreak(String s, List<String> wordDict)
	{
		Set<String> set = new HashSet<>(wordDict);
		System.out.println(set);
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1;i<s.length()+1;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(dp[j] && set.contains(s.substring(j,i)))
				{
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		List<String> wd = new ArrayList<String>(); //{"leet", "code"}:
		wd.add("leet");
		wd.add("code");
		System.out.println(wb.wordbreak("leetcode", wd));
	}
}
