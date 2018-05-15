import java.util.Arrays;
// Approach 1 - Count zeroes, Swap non zero elements and Add Zero's at the end - More operations are involved
/*public class Movezeroes {
	public static int[] movezeroes(int[] lst){
		int zero_cnt = 0;
		// Calculate numbers of zeroes in given array
		for(int i=0;i<lst.length;i++)
		{
			if(lst[i] == 0)
			{
				zero_cnt += 1;
			}
		}
		removenum(lst,0);
		addzero(lst,zero_cnt);
		return lst;
		
		}
		// This function uses two pointer technique to move non zero numbers forward in the array
		public static int[] removenum(int[] numbers, int target) 
		{ 
		      if(numbers.length==0) return numbers; 
		      int i=0; 
		      for(int j=0; j<numbers.length; j++)
		      {
		        if(numbers[j]!=target)
		        {
		        	numbers[i]=numbers[j];
		          i++; 
		        }
		      }
		 return numbers;
		}
		// This function adds zeros at the end. The number of zeroes add = zero count
		public static int[] addzero(int[] nums,int zero_cnt)
		{
			for(int i=nums.length-1;i>=zero_cnt;i--)
			{
				nums[i] = 0;
			}
		return nums;
		}
		
	public static void main(String[] args) {
		int[] arr = {2,0,0,2,0,1};
		System.out.println(Arrays.toString(movezeroes(arr)));
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
