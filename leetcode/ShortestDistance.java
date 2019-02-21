/* Shortest Word Distance
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

class ShortestDistance{
	public int distance(String[] words, String word1, String word2)
	{
		int index1 = -1;
		int index2 = -1;
		int mindistance = words.length;
		for(int i=0;i<words.length;i++)
		{
			if(words[i].equals(word1))
			{
				index1 = i;
			}
			if(words[i].equals(word2))
			{
				index2 = i;
			}
			if(index1 >=0 && index2 >= 0)
			{
			mindistance = Math.min(Math.abs(index1-index2), mindistance);
			}
		}
		return mindistance;
	}
	public static void main(String[] args)
	{
		ShortestDistance sd = new ShortestDistance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(sd.distance(words, "coding"+"", "practice"+""));
		System.out.println(sd.distance(words, "makes"+"", "coding"+""));
	}
}

