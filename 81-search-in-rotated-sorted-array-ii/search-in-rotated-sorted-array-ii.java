class Solution {
    public boolean search(int[] nums, int target) 
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<=r)
        {
            int m=(l+r)/2;
            if(nums[m] == target)
                return true;

            if (nums[l] == nums[m] && nums[m] == nums[r])   //To reomove duplicates
            {
                l++;
                r--;
                continue;
            }
            
            if(nums[l] <= nums[m]) //left sorted part
            {
                if(target>=nums[l] && target<nums[m]) 
                {
                    r=m-1;
                }
                else  
                {
                    l=m+1;
                }
            }
            else
            {
               if(target>nums[m] && target<=nums[r]) 
                {
                    l=m+1;
                }
                else  
                {
                    r=m-1;
                } 
            }
        }
        return false;
        
    }
}