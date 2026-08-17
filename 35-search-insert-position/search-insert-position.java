class Solution {
    public int searchInsert(int[] nums, int target)
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ind=n;
        for(int i=0;i<n;i++)
        {
            int m=(l+r)/2;
            if(nums[m] >= target)
            {
                ind=m;
                r=m-1;
            }
            else if(nums[m] < target)
            {
                l=m+1;
            }
        }
        return ind;
    }
}