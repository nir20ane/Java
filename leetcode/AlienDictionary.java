/*Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.
Example 1:
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
Output: "wertf"
Example 2:
Input:
[
  "z",
  "x"
]
Output: "zx"
Example 3:
Input:
[
  "z",
  "x",
  "z"
] 
Output: "" 
Explanation: The order is invalid, so return "".
Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

package leetcodenew;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
	
	public String AlienOrder(String[] words) {
		if(words == null || words.length == 0) return "";
		String result = "";
		HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
		HashMap<Character, Integer> degree = new HashMap<Character, Integer>();
		for(String str: words)
		{
			for(char ch: str.toCharArray())
			{
				degree.put(ch, 0);
			}
		}
		
		for(int i=0; i<words.length-1; i++)
		{
			String curr = words[i];
			String next = words[i+1];
			int len = Math.min(curr.length(), next.length());
			for(int j=0;j<len;j++)
			{
				char c1 = curr.charAt(j);
				char c2 = next.charAt(j);
				if(c1 != c2)
				{
					HashSet<Character> set = new HashSet<>();
					if(map.containsKey(c1)) set = map.get(c1);
					if(!set.contains(c2))
					{
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2)+1);
					}
					break;
				}
			}
		}
		System.out.println(degree.toString());
		System.out.println(map.toString());		
		Queue<Character> que = new LinkedList<>();
		for(char ch:degree.keySet())
		{
			if(degree.get(ch) == 0) que.add(ch);
		}
		System.out.println(que.toString());
		while(!que.isEmpty())
		{
			char n = que.remove();	
			if(map.containsKey(n))
			{
				for(char ch:map.get(n))
				{
					degree.put(ch, degree.get(ch)-1);
					if(degree.get(ch) == 0) que.add(ch);
				}
			}
		}
		System.out.println(degree.toString());
		if(result.length() != degree.size()) return "";
		return result;
	}

	public static void main(String[] args) {
		AlienDictionary ald = new AlienDictionary();
		String[] words = {"wrt","wrf","er","ett","rftt"};
		System.out.println(ald.AlienOrder(words));
	}
}
