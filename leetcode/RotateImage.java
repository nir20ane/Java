/**You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
** Approach:
* for i = 0 to n
* variable temp = top[i];
* top[i] = left[i]
* left[i] = bottom[i]
* bottom[i] = right[i]
* right[i] = temp
* Time Complexity: O(n^2); Space Complexity O(1)
*/
import java.util.Arrays;
public class RotateImage {
	    public void rotate(int[][] matrix) {
	        for(int[] row : matrix) System.out.println(Arrays.toString(row));
	        int n = matrix.length; // calculate length of matrix
	        for(int i=0; i<n; i++)
	        {
	            if(n==0 || (matrix[0].length < n)) break; //break if it is not a valid matrix
	            int first = i;  // calculate first
	            int last = n-i-1;  // calculate last
	            for(int j=first;j<last;j++)
	            {
	                int offset = j - first;  // calculate offset
	                int top = matrix[first][j];
	                matrix[first][j] = matrix[last - offset][first]; // left to top
	                matrix[last - offset][first] = matrix[last][last - offset]; // bottom to left
	                matrix[last][last - offset] = matrix[j][last]; // right to bottom
	                matrix[j][last] = top; // top to right
	            }
	        }
	        for(int[] row: matrix) System.out.println(Arrays.toString(row));
	    }
	public static void main(String[] args) {
		RotateImage rot = new RotateImage();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rot.rotate(matrix);

	}

}
