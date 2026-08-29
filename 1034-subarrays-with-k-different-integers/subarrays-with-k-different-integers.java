class Solution 
{
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        return subarraysWithLessThanKDistinct(nums, k) - subarraysWithLessThanKDistinct(nums, k-1);
    }
    public int subarraysWithLessThanKDistinct(int[] nums, int k) 
    {
        int n=nums.length;
        HashMap<Integer, Integer> hm=new HashMap<>();
        int l=0;
        int r=0;
        int c=0;
        while(r<n)
        {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0)+1);

            while(hm.size() > k)
            {
                hm.put(nums[l], hm.get(nums[l])-1);
                if(hm.get(nums[l]) == 0)
                    hm.remove(nums[l]);
                l++;
            }
            if(hm.size() <= k)
            {
                c+=(r-l+1);
                r++;
            }
        }
        return c;
    }
}