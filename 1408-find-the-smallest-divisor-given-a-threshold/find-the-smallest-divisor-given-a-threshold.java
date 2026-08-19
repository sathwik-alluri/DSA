class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
        int n=nums.length;
        int max=nums[0];
        for(int i=0;i<n;i++)
        {
            max=Math.max(nums[i], max);
        }
        int l=1;
        int r=max;
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;

            long sum = fun(nums, mid);
            if(sum <= threshold)
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
    public long fun(int[] nums, int div) 
    {
        int n=nums.length;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            sum += (long)Math.ceil((double) nums[i]/ div);
        }
        return sum;
    }
}