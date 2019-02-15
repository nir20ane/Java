/*Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
*/
package leetcodenew;

public class RegularExpMatching {
	public boolean isMatch(String s, String p)
	{
		if(p == null || s ==  null)
		{
			return false;
		}
		if(p.length() == 0)
		{
			return p.length()==s.length();
		}
		s = "+"+s;
		p = "p"+p;
		boolean[][] dp = new boolean[s.length()][p.length()];
		dp[0][0] = true;
		for(int j=1;j<p.length();j++)
		{
			if(p.charAt(j) == '*') dp[0][j] = dp[0][j-2];
		}
		for(int i=1;i<s.length();i++)
		{
			for(int j=1;j<p.length();j++)
			{
	            //Case 1: direct character match
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
				{
					dp[i][j] = dp[i-1][j-1];
				}
				if(p.charAt(j) == '*') {
	                //Case 2: character directly behind star doesn't match, skip
					if((s.charAt(i) != p.charAt(j-1)) && (p.charAt(j-1) != '.'))
					{
						dp[i][j] = dp[i][j-2];
					}
	                //Extend out character before *
					else
					{
	                    //dp[i][j-1]: If character before * appears once
	                    //dp[i-1][j]: If character before * appears more than once
	                    //dp[i][j-2]: If skip is necessary to match (even if c matches)
						dp[i][j] = dp[i-1][j] || dp [i][j-1] || dp[i][j-2];
					}
				}
			}
		}
        return dp[s.length()-1][p.length()-1];
	} 
	public static void main(String[] args) {
		RegularExpMatching regexp = new RegularExpMatching();
		System.out.println(regexp.isMatch("aa", "a"));
		System.out.println(regexp.isMatch("aab", "c*a*b"));
		System.out.println(regexp.isMatch("mississippi", "mis*is*p*."));
	}
}
