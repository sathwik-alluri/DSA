class Solution {
    public int findPeakElement(int[] nums) 
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        if(n==1)
            return 0;
        while(l<=r)
        {
            int m=(l+r)/2;
            if((m==0 || nums[m-1] < nums[m]) && (m==n-1 || nums[m] > nums[m+1]))
                return m;

            if(nums[m] < nums[m+1])
                l=m+1;
            else //if(m>l && nums[m-1] > nums[m])
                r=m-1; 
        }
        return -1;
    }
}