/** 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
* bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
* Approach:
* for i = 0 to n
* temp= top[i];
* top[i] = left[i]
* left[i] = bottom[i]
* bottom[i] = right[i]
* right[i] = temp
* Time Complexity: O(n^2); Space Complexity O(1)
 */
import java.util.Arrays;
public class RotateMatrix
{
	public int[][] rotate(int[][] matrix)
	{
		int n = matrix.length; // calculate length of matrix
		if(n == 0 || (matrix[0].length < n)) return new int[][] {}; // return false if matrix is not valid
		for(int i=0;i<n/2;i++) // iterate through length/2
		{
			int first = i; // calculate first and last for iteration
			int last = n-i-1;
			for(int j = first; j<last;j++)
			{
				int offset = j - first; // calculate offset
				int top = matrix[first][j]; // left to top
				matrix[first][j] = matrix[last-offset][first]; // bottom to left
				matrix[last-offset][first] = matrix[last][last-offset]; // right to bottom
				matrix[last][last-offset] = matrix[j][last]; // top to right
				matrix[j][last] = top;
			}
		}
		return matrix; 
	}
	public static void main(String[] args) {
		RotateMatrix rot = new RotateMatrix();
		int[][] matrix = {{1,2,3,},{4,5,6,},{7,8,9,}};
		for (int[] row : matrix)  System.out.println(Arrays.toString(row));
		matrix = rot.rotate(matrix);
		for (int[] row : matrix) System.out.println(Arrays.toString(row)); 
		int[][] matrix1 = {{1,2,},{3,4}};
		for (int[] row : matrix1)  System.out.println(Arrays.toString(row));
		matrix = rot.rotate(matrix1);
		for (int[] row : matrix1) System.out.println(Arrays.toString(row)); 
 }
}

