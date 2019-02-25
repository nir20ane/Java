/* Letter Combinations of a Phone Number

* Given a string containing digits from 2-9 inclusive, 
* return all possible letter combinations that the number could represent.
* A mapping of digit to letters (just like on the telephone buttons) is given below. 
* Note that 1 does not map to any letters.

* Example:
* Input: "23"
* Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
package leetcodenew;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {

	public LinkedList<String> lettercombination(String digits)
	{
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return  ans;
		ans.add("");
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0;i<digits.length();i++)
        {
            int x = Character.getNumericValue(digits.charAt(i));
            System.out.println(x);
            while(ans.peek().length() == i) {
             {
               String t = ans.remove();
               for(char s:mapping[x].toCharArray())
               {
                   ans.add(t+s+"");
               }
            }
        }
        }
		return ans;
	}
	public static void main(String[] args) {
		LetterCombinationsofPhoneNumber lcb = new LetterCombinationsofPhoneNumber();
		List<String> ans = lcb.lettercombination("23");
		System.out.println(ans);
	}
}
