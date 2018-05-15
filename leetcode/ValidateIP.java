/*Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
Note: You may assume there is no extra space or special characters in the input string.
Example 1:
Input: "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"
Output: "Neither"*/

//Approach 1: For IPv4 - validate for number,len and range, for IPv6 - validate for len, hex value>0 and '-' symbol
public class ValidateIP {
	    public static String validIPAddress(String IP) {
	        if(IP.length() == 0) return "Neither";
			else if(isIPv4(IP)) return "IPv4";
			else if(isIPv6(IP)) return "IPv6";
			else return "Neither";
		}
		public static Boolean isIPv4(String str)
		{
	        if((str.charAt(str.length() - 1)) == '.') return false;
			String[] s = str.split("\\.");
			if(s.length!=4) return false;
			for(int i=0;i<s.length;i++)
			{
				if(!validateIPv4(s[i])) return false;
			}
			return true;
		}
		public static Boolean validateIPv4(String s)
		{
	        try
			{
				int a = Integer.parseInt(s);
	            if(a>255) return false;
				if(a<0) return false;
				if(!(String.valueOf(a).equals(s))) return false;
			}
			catch(NumberFormatException e)
	        {
	            return false;
	        }
		    return true;	
		}
		
		public static Boolean isIPv6(String str)
		{
	        if((str.charAt(str.length() - 1)) == ':') return false;
	        if(str.contains("::")) return false;
			String[] s = str.split(":");
			if(s.length!=8) return false;
			for(int i=0;i<s.length;i++)
			{
	            if(s[i].equals(null)) return false;
				if(!validateIPv6(s[i])) return false;
			}
			return true;
		}
		public static Boolean validateIPv6(String s)
		{
			if(s.length()>4) return false;
			char[] ch = s.toCharArray();
			for(char c:ch) {
				boolean isDigit = c>=48 && c<=57;
				boolean isUppercaseAF = c>=65 && c<=70;
				boolean isLowerCaseAF = c>=97 && c<=102;
				if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
					return false;
			}
			return true;
		}
	        

	public static void main(String[] args) {
		System.out.println(validIPAddress("111.16.254.1"));
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("1eq.16.254.1"));
		System.out.println(validIPAddress(""));
		System.out.println(validIPAddress("1eq.16.254.1."));
		System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:db8:85a3:0::8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress("2001:db8:85am:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress("-2001:db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334:9876"));
		System.out.println(validIPAddress("172.16.254"));
	}
}
