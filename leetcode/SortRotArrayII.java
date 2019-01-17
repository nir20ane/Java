class SortRotArrayII {
     public boolean search(int[] nums, int target) {
        if(nums.length < 1) return false;
        if((nums.length == 0) && (nums[0] == target)) return true;
        if((nums.length == 0) && (nums[0] != target)) return false;
        
        int pivot = 0;
        boolean left = false;
        boolean right = false;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > nums[i+1]) pivot = i;
            break;
        }
        if(nums[pivot] == target) return true;
        else
        {
            left  =  binarySearch(nums, 0, pivot, target);
            right = binarySearch(nums, pivot+1, nums.length-1, target);
        }
        return (left || right);

        }
     
     public boolean binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = (end + start) / 2;
            if(nums[mid] == target) {
                return true;
            } 
            else if(nums[mid] < target) {
                start = mid + 1;
            } 
            else {
            end = mid - 1;
             }
    }
        return false;
    }
     public static void main(String[] args){
    	 int[] nums = {2, 5, 6, 0, 0, 1, 2}; 
    	 int target = 0;
    	 SortRotArrayII sortrot = new SortRotArrayII();
    	 System.out.println(sortrot.search(nums, target));
    	 int target1 = 3;
    	 System.out.println(sortrot.search(nums, target1));
     }
     }
    		 
