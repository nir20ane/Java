/*The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.
Example 1:
Input: 1
Output: "1"
Example 2:
Input: 4
Output: "1211"*/
//Approach 1: keep track of prev_string, prev_char and number of repeats
public class Count_and_say {
	public static String count_and_say(int n){
		if(n==0 || n==1) {
			return "1";
		}
		String prev_string = count_and_say(n-1);
		//System.out.println("prev_string" +prev_string);
		char prev_char = prev_string.charAt(0);
		//System.out.println("prev_char" +prev_char);
		char curr_char = '\0';
		int number_of_repeats = 0;
		String res_string = "";
		for(int i=0;i<prev_string.length();i++)
		{
			curr_char=prev_string.charAt(i);
			if(curr_char==prev_char)
			{
				number_of_repeats+=1;
			}
			if(curr_char!=prev_char)
			{
				res_string += Integer.toString(number_of_repeats)+prev_char;
				prev_char = curr_char;
				number_of_repeats=1;
			}
		}
		res_string += Integer.toString(number_of_repeats)+curr_char;
		return res_string;
	}

	public static void main(String[] args) 
	{
		System.out.println(count_and_say(1));
		System.out.println(count_and_say(2));
		System.out.println(count_and_say(3));
		System.out.println(count_and_say(4));
		System.out.println(count_and_say(5));
	}

}
