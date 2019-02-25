/* Generate Parentheses
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
* For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
package leetcodenew;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateparan(int num)
    {
    	List<String> res = new ArrayList<String>();
    	if(num <= 0)
    	{
    		return res;
    	}
    	generate(num, num, "", res);
    	return res;
    }
    public static void generate(int lparan, int rparan, String prog, List<String> res)
    {
    	if(lparan == 0 && rparan == 0)
    	{
    		res.add(prog);
    	}
    	if(lparan > 0)
    	{
    		generate(lparan-1, rparan, prog+"(", res);
    	}
    	if(lparan < rparan)
    	{
    		generate(lparan, rparan-1, prog+")", res);
    	}
    }
	public static void main(String[] args) {
		GenerateParanthesis gp = new GenerateParanthesis();
		System.out.println(gp.generateparan(3).toString());
	}
}
