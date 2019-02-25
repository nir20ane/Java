/*Jewels and Stones
* You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
* Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
* The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
* so "a" is considered a different type of stone from "A".
* Example 1:
* Input: J = "aA", S = "aAAbbbb"
* Output: 3
* Example 2:
* Input: J = "z", S = "ZZ"
*/
package leetcodenew;

import java.util.HashSet;

public class JewelsStones {
	
	public int stoneisjewel(String Jewel, String Stone)
	{
		int count = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(char j:Jewel.toCharArray())
		{
			set.add(j);
		}
		for(char s:Stone.toCharArray())
		{
			if(set.contains(s))
			{
				count += 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		JewelsStones js = new JewelsStones();
		System.out.println(js.stoneisjewel("aA", "aAAbbbb"));
		System.out.println(js.stoneisjewel("z", "ZZ"));
	}
}
