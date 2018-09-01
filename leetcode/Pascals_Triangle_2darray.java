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
// Method 1: uses two D arrays
import java.util.Arrays;
public class Pascals_Triangle_2darray
{
	public static int[][] pascal_traingle(int n)
	{
		// Create a 2d array
		int[][] pascal = new int[n][];
		for(int i=0;i<n;i++)
		{
			// determine a column for each row
			pascal[i] = new int[i+1];
			// first value is always 1
			pascal[i][0] = 1;
			// calculate the mid values
			for(int j=1;j<i;j++) {
				pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
			}
			if (i>0)
			{
				// last value is always 1 for i > 0
				pascal[i][i] = 1;
			}
		}	
		// return the pascal values
		return pascal;
	}
	public static void main(String[] args)
	{
		// print the pascal triangle
		System.out.println(Arrays.deepToString(pascal_traingle(5)));
	}
}