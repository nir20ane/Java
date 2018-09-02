/*Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
In Pascal's triangle, each number is the sum of the two numbers directly above it.
Example:
Input: 3
Output: [1,3,3,1]*/
//Method: List of List
import java.util.*;
public class Pascal_TriangleII_ArrayList{
    public static List<Integer> getRow(int rowIndex) {
    	//declare an array list
        List<List<Integer>> pascal = new ArrayList<>(rowIndex);
        for(int i=0;i<rowIndex+1;i++)
        {   // create a new arraylist for every row
        	List<Integer> array = new ArrayList<>(i+1);
        	for(int j=0;j<=i;j++)
        	{   // add 1 if j is 0 or i
        		if(j==0||j==i) array.add(1);
        		else
        		{
        			// compute and add values to array otherise
        			array.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
        		}
        	}
        	//add array to pascal
        	pascal.add(array);
        }    
       // return pascal row
       return pascal.get(rowIndex);
    }

    public static void main(String[] args)
    {
    	System.out.println(getRow(3));
    }
}
