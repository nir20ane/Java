/*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.
Example:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.*/
public class Hamming_distance {
	public static int calc_distance(int x, int y)
	{
		int count = 0;
		int diff = x^y;
		while(diff != 0)
		{
			diff = diff&(diff-1);
			count += 1;
		}
		return count;
	}

	public static void main(String[] args) {
		
		System.out.println(calc_distance(1,4));
	}

}
