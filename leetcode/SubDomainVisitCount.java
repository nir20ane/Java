/*Subdomain Visit Count
A website domain like "discuss.leetcode.com" consists of various subdomains. 
At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". 
When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. 
An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. 
We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

Example 1:
Input: 
["9001 discuss.leetcode.com"]
Output: 
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation: 
We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

Example 2:
Input: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: 
We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
*/
package leetcodenew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubDomainVisitCount {
	
	public List<String> subdomaincnt(String[] cpdomains)
	{
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String cp:cpdomains)
		{
			int ind = cp.indexOf(" ");
		    String nn = cp.substring(0, ind);
			int n = Integer.valueOf(nn);
			String s = cp.substring(ind+1);
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i) == '.')
				{
					String d = s.substring(i+1);
					map.put(d, map.getOrDefault(d, 0)+n);
				}
			}
			map.put(s, map.getOrDefault(s, 0)+n);
		}
		for(String r:map.keySet())
		{
			res.add(map.get(r)+" "+r);
		}
		
		return res;
	}

	public static void main(String[] args) {
		SubDomainVisitCount sdvc = new SubDomainVisitCount();
		String[] cp = new String[]{"9001 discuss.leetcode.com"};
		String[] cp1 = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		List<String> res = sdvc.subdomaincnt(cp);
		List<String> res1 = sdvc.subdomaincnt(cp1);
		System.out.println(res);
		System.out.println(res1);
	}
}
