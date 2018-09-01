// Approach 1 - Count zeroes, Swap non zero elements and Add Zero's at the end - More operations are involved
/*import java.util.Arrays;
public class Move_zeroes {
    public static void main(String[] args)
    {
       int [] arr = {0,1};
   	   moveZeroes(arr);
   	   System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) 
    { 
        int index = removenum(nums,0);
	    addzero(nums,index);		
		}
		// This function uses two pointer technique to move non zero numbers forward in the array
	public static int removenum(int[] numbers, int target) 
	{ 
        int index = 0;
		for(int j=0; j<numbers.length; j++)
		{
		   if(numbers[j]!=target)
		   {
		      numbers[index] = numbers[j];
		      index += 1; 
		    }
		 }
        System.out.println(index);
		return index;
		}
		// This function adds zeros at the end, starting from non zero index till lenth
		public static int[] addzero(int[] nums,int index)
		{
			for(int i=index;i<nums.length;i++)
			{
				nums[i] = 0;
			}
		return nums;
		}
}*/
// Approach 2
public class Movezeroes{
	public static void main(String[] args) {
		int[] arr = {2,0,0,2,0,1};
		System.out.println(Arrays.toString(movezeroes(arr)));
	}
	public static int[] movezeroes(int[] nums)
	{
		int j =0;
		for(int i =0;i<nums.length;i++)
		{
			if(nums[i] != 0)
			{
				int temp = nums[j];
				nums[j]=nums[i];
				nums[i]= temp;
				j+=1;
			}
		}
		return nums;
	}
	
}
