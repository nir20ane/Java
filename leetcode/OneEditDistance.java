/** One Away: There are three types of edits that can be performed on strings: insert a character,
* remove a character, or replace a character. Given two strings, write a function to check if they are
* one edit (or zero edits) away.
* EXAMPLE
* pale, ple -> true
* pales, pale -> true
* pale, bale -> true
* pale, bae -> false
* Approach - increase count if there is a mismatch in character or length
* increase index 1 if string1 length is more and index 2 if string 2 length is more
* Time Complexity O(n); Space Complexity O(1)
*/
public class OneEditDistance {
	
	public boolean oneEditDistance(String str1, String str2)
	{
		int len1 = str1.length();
		int len2 = str2.length();
		int index1=0, index2 = 0;
		int count = 0;
		if(Math.abs(len1 - len2) > 1) return false; //if length diff is more than 1 return false
		while((index1 < len1) && (index2 < len2))
		{
		    if(str1.charAt(index1) != str2.charAt(index2))
		    {
		    	if(count == 1) return false; // return false if count is 1 already
		    	if(len1 < len2) index2++; // increase index2 if string 2 is longer
		    	else if(len1 > len2) index1++; // increase index1 if string 1 is longer
		    	else
		    	{
		    		index1++; // increase indexes if len of both strings are same
		    		index2++;
		    	}
		    	count++; // increase count if character do not match
		    }
		    else
		    {
		    	index1++;
		    	index2++;   // increase indexes if characters match
		    }
		}
		if((index1 < len1) || (index2 < len2))
		{
			count++; // increase count if there is an extra character at end
		}
		return count == 1; //check for count value 1
	}

	public static void main(String[] args) {
		OneEditDistance one = new OneEditDistance();
		System.out.println(one.oneEditDistance("pale","bale"));
		System.out.println(one.oneEditDistance("pale","balee"));
		System.out.println(one.oneEditDistance("ale","bale"));
		System.out.println(one.oneEditDistance("bale","bal"));
		System.out.println(one.oneEditDistance("bal","bal"));
		System.out.println(one.oneEditDistance("bale","baleee"));
	}

}
