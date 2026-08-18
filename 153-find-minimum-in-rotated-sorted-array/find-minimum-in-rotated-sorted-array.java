class Solution {
    public int findMin(int[] nums) 
    {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ans=nums[0];
        while(l<=r)
        {
            int m=(l+r)/2;
            if(nums[l] < nums[m]) //Left part is sorted
            {
                ans=Math.min(ans, nums[l]);
                l=m+1;
            }
            else if(nums[m] < nums[r])
            {
                ans=Math.min(ans, nums[m]);
                r=m-1;
            }
            else
            {
                ans=Math.min(ans, Math.min(nums[l], nums[r]));
                l++;
                r--;
            }
        }
        return ans;
    }
}