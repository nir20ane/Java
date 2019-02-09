/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.
*/
package leetcodenew;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
	
	public boolean validparan(String str)
	{
		Stack<Character> stck = new Stack<Character>();
		if(str.length() == 0) return true;
		if(str.length()%2 == 1) return false;
		HashMap<Character, Character> map = new HashMap<>();
		map.put('}','{');
		map.put(']','[');
		map.put(')','(');  // hashmap with all paranthesis as key and value
		
		for(int i=0;i<str.length();i++)
		{
		    char ch = str.charAt(i);
			if(map.containsKey(ch))
			{
				char top = stck.isEmpty()? '#' : stck.pop();
				if(top != map.get(ch)) return false;
			}
			else
			{
				stck.push(ch);
			}
		}
		return stck.isEmpty();  // this is important
	}

	public static void main(String[] args) {
		ValidParanthesis valparan = new ValidParanthesis();
		System.out.println(valparan.validparan("{}"));
		System.out.println(valparan.validparan("(){}[]"));
		System.out.println(valparan.validparan("()]["));
	}
}
