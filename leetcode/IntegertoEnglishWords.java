/* Integer to English Words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:
Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/
package leetcodenew;

public class IntegertoEnglishWords {
	
    public static String[] lessthan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] thousands = {"", "Thousand", "Million", "Billion"};
    
	public String inttowords(int num)
	{	
		if(num == 0) return "Zero";
		String words = "";
		int i = 0;
		while(num > 0)
		{
			if(num%1000 != 0)
			{
				words = helper(num%1000)+" "+thousands[i]+" "+words;
			}
			num = num/1000;
			i += 1;
		}
		return words.trim();
	}
	public static String helper(int num)
	{
		if(num == 0) return "";
		else if(num < 20)
		{
			return lessthan20[num]+"";
		}
		else if(num < 100)
		{
			return tens[num/10]+" "+helper(num%10);
		}
		else
		{
			return lessthan20[num/100]+" Hundred "+helper(num%100);
		}
	}
	public static void main(String[] args)
	{
		IntegertoEnglishWords intoeng = new IntegertoEnglishWords();
		System.out.println(intoeng.inttowords(1234567891));
		System.out.println(intoeng.inttowords(123456));
		System.out.println(intoeng.inttowords(123));
		System.out.println(intoeng.inttowords(1234567));
	}
}
