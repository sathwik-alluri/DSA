class Solution {
    public int singleNonDuplicate(int[] nums) 
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<=r)
        {
            int m=(l+r)/2;
            if((m==0 || nums[m] !=nums[m-1]) && (m==n-1 || nums[m]!=nums[m+1]))
            {
                return nums[m];
            }
            
            if(m<r && nums[m] != nums[m+1])
            {
                if(m%2 != 0)
                {
                    l=m+1;
                }
                else
                {
                    r=m-1;
                }
            }
            if(l<m && nums[m] != nums[m-1])
            {
                if(m%2 == 0)
                {
                    l=m+1;
                }
                else
                {
                    r=m-1;
                }
            }
        }
        return 0;
    }
}