class Solution {
    public int numberOfSubarrays(int[] nums, int k) 
    {
        return SubarrayswithsumLessThanK(nums, k) - SubarrayswithsumLessThanK(nums, k-1);
    }
    public int SubarrayswithsumLessThanK(int[] nums, int k) 
    {
        int n=nums.length;
        int l=0;
        int r=0;
        int sum=0;
        int c=0;
        while(r < n)
        {
            sum+=(nums[r] % 2);     //If the num is odd, 1 will be added and vice versa

            while(sum > k)
            {
                sum-=(nums[l] % 2);
                l=l+1;
            }
            if(sum <= k)
            {
                c+= (r-l+1);
                r=r+1;
            }
        }
        return c;
    }
}