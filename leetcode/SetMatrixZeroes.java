import java.util.Arrays;

/** Set Zero Matrices
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
Example 1:
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
* Approach:
* Use boolean values to keep track of 0's in 0th row and column
* use 0th row and 0th column to keep track of 0's elsewhere
* nullify rows and column based on the 0th row and column values
* nullify 0th row and column if there booleans are True
* Time Complexity: O(n^2)
* Space Complexity: O(1)
*/
public class SetMatrixZeroes {
	 public int[][] setZeroes(int[][] matrix) {
	     boolean rowhaszero = false;
	     boolean columnhaszero = false; // use booleans for 0's in 0th row and column
	        
	     for(int j=0; j<matrix[0].length; j++)
	     {
	        if(matrix[0][j] == 0) rowhaszero = true; // Update boolean if row 0 has 0 in it
	     }
	     for(int i=0; i<matrix.length; i++)
	     {
	        if(matrix[i][0] == 0) columnhaszero = true; // Update boolean if column 0 has 0 in it
	     }
	        
	     for(int i=1; i<matrix.length; i++)
	     {
	        for(int j=1; j<matrix[0].length; j++)
	        {
	           if(matrix[i][j] == 0)
	           {
	              matrix[0][j] = 0;
	              matrix[i][0] = 0; // for any value 0 in matrix starting from row1 column1, use 1st row and column as replacement
	            }
	        }
	      }
	     for(int i=1; i<matrix.length; i++)
	     {
	        if(matrix[i][0] == 0) rowzero(matrix, i); //for any 0 in row1 to n, nullify that row 
	     }
	     for(int j=1; j<matrix[0].length; j++)
	     {
	        if(matrix[0][j] == 0) columnzero(matrix, j); // for any 0 in column1 to matrix[0].length nullify that column
	     }
	     if(rowhaszero) rowzero(matrix, 0);  // nullify row 0 if boolean true
	     if(columnhaszero) columnzero(matrix, 0); // nullify column 0 if boolean true
	     
	     return matrix;
	   }
	 public void rowzero(int[][] matrix, int row)
	 {
	    for(int j=0; j<matrix[0].length; j++)
	    {
	        matrix[row][j] = 0; // nullify a complete row based on row value provided
	    }
	 }
	    
	 public void columnzero(int[][] matrix, int column)
	 {
	    for(int i=0; i<matrix.length; i++)
	    {
	       matrix[i][column] = 0; // nullify a complete column based on column value provided
	    }
	 }
	public static void main(String[] args) {
		SetMatrixZeroes setmat = new SetMatrixZeroes();
		int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		matrix = setmat.setZeroes(matrix);
		for(int[] m: matrix)
		{
			System.out.println(Arrays.toString(m));
		}
		
		

	}

}
