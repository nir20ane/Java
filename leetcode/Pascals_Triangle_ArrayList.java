/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

In Pascal's triangle, each number is the sum of the two numbers directly above it.*/
// Method 2 using array list in java
import java.util.*;
public class Pascals_Triangle_ArrayList {
	public static ArrayList<List<Integer>> pascal_triangle(int n)
	{
		// declare an array list
		ArrayList<List<Integer>> pascal = new ArrayList<List<Integer>>(n);
		// return arraylist if n<=0
		if(n <= 0)
		{
			return pascal;
		}
        for(int i=0;i<n;i++)
        {
        	// create an array list of size i+1 for all i if n>0
            List<Integer> array = new ArrayList<Integer>(i+1);
            for(int j=0;j<=i;j++)
            {
            	// if j is 0 or i add 1
                if(j==0||j==i)
                {
                    array.add(1);
                }
                // for all other j all previous row numbers j-1 and j
                else
                {
                    array.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
                }            
            }
            // add array to pascal
            pascal.add(array);
        }
        // return pascal 
        return pascal;
	}
	public static void main(String[] args)
	{
		// function call and print
		System.out.println(pascal_triangle(5));
	}

}
