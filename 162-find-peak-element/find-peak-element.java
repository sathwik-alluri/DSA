class Solution {
    public int findPeakElement(int[] nums) 
    {
        int n=nums.length;
        // int l=0;
        // int r=n-1;
        if(n==1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[n-1] > nums[n-2])
            return n-1;

        int l=1;
        int r=n-2;
        while(l<=r)
        {
            int m=(l+r)/2;

            // if((m==0 || nums[m-1] < nums[m]) && (m==n-1 || nums[m] > nums[m+1]))
            //     return m;
            if(nums[m-1] < nums[m] && nums[m] > nums[m+1])
                return m;

            if(nums[m] < nums[m+1])
                l=m+1;
            else 
                r=m-1; 
        }
        return -1;
    }
}