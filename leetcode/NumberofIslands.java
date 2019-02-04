/* Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input:
11110
11010
11000
00000
Output: 1
Example 2:
Input:
11000
11000
00100
00011
Output: 3
** Approach: when you get a value 1, go and visit all nearby nodes, and mark then as 0, 
* increment count when no other nearby node is 1
* Time Complexity: O(m*n) = where m is rows and n is columns
* Space COmplexity: O(1)
*/
package leetcodenew;
public class NumberofIslands{
	
	private static int n;
	private static int m;
	private static int count;
	
	public int islands(int[][] grid)
	{
		count = 0;
		if(grid.length == 0) return 0;
		n = grid.length;
		m = grid[0].length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j] == 1)  // if value in grid is 1
				{
					shrink(grid, i, j);  // check for near by values and make then as 0 if they are 1
					count+=1;
				}
			}
		}
		return count;
	}
    
	public static void shrink(int[][] grid, int x, int y)
	{
		if(x<0||y<0||x>=n||y>=m||grid[x][y] != 1) return; // if vales are out of range or 0, return
		grid[x][y] = 0; // else make the grid value as 0 and proceed to near by values
		shrink(grid, x, y+1);
		shrink(grid, x, y-1);
		shrink(grid, x+1, y);
		shrink(grid, x-1, y);
	}
	
	public static void main(String[] args)
	{
		NumberofIslands numis = new NumberofIslands();
		int[][] grid = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0},{0,0,0,0,0}};
		System.out.println(numis.islands(grid));
		
	}
}
