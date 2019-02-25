/*Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
* Any live cell with fewer than two live neighbors dies, as if caused by under-population.
* Any live cell with two or three live neighbors lives on to the next generation.
* Any live cell with more than three live neighbors dies, as if by over-population..
* Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
* Write a function to compute the next state (after one update) of the board given its current state. 
* The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
* Example:
* Input: 
* [
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
* ]
* Output: 
* [
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
* ]
* Follow up:

* Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
* In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/
package leetcodenew;

import java.util.Arrays;

public class GameofLife {
    public void result(int[][] board)
    {
    	int row = board.length;
    	int column = board[0].length;
    	
    	for(int i=0;i<row;i++)
    	{
    		for(int j=0;j<column;j++)
    		{
    			int neighbors = getneighbors(board, i, j);
    			if(board[i][j] == 1)
    			{
    				if(neighbors ==2 || neighbors == 3)
    				{
    					board[i][j] = 3;
    				}
    			}
    			else
    			{
    				if(neighbors == 3)
    				{
    					board[i][j] = 3;
    				}
    			}
    		}
    	}
    	for(int i=0;i<row;i++)
    	{
    		for(int j=0;j<column;j++)
    		{
    			board[i][j] >>=1;
    		}
    	}
    }
    public static int getneighbors(int[][] board, int row, int column)
    {
    	int count = 0;
    	for(int i=row-1;i<=row+1;i++)
    	{
    		for(int j=column-1;j<=column+1;j++)
    		{
    			if(i>=0 && i<board.length && j>=0 && j<board[0].length)
    			{
    				count += board[i][j]&1;
    			}
    		}
    	}
    	count -= board[row][column]&1;
    	return count;
    }
	public static void main(String[] args) {
		GameofLife gl = new GameofLife();
		int[][] res = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
		for(int[] row:res)
		{
			System.out.println(Arrays.toString(row));
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		gl.result(res);
		for(int[] row:res)
		{
			System.out.println(Arrays.toString(row));
		}
	}

}
