class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        return SubarraysWithSumLessThanOrEqualToSumK(nums, goal) - SubarraysWithSumLessThanOrEqualToSumK(nums, goal-1);
    }
    public int SubarraysWithSumLessThanOrEqualToSumK(int[] nums, int goal) 
    {
        int n=nums.length;
        if(goal == -1)
            return 0;
        int l=0;
        int r=0;
        int c=0;
        int sum=0;
        while(r<n)
        {
            sum+=nums[r];
            while(sum > goal)
            {
                sum-=nums[l];
                l++;
            }
            if(sum <= goal)
            {
                c+=(r-l+1);
                r=r+1;
            }
        }
        return c;
    }
}