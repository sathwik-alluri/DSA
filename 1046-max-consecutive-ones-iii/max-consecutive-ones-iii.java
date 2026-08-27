class Solution {
    public int longestOnes(int[] nums, int k) 
    {
        int n=nums.length;
        int l=0;
        int r=0;
        int c=0;
        int maxLen=0;
        PriorityQueue<Integer> ZeroIndexes = new PriorityQueue<>();
        while(r<n)
        {
            if(nums[r] == 1)
            {
                maxLen=Math.max(maxLen, r-l+1);
                r++;
            }
            else    //Ele is 0
            {
                c+=1;
                ZeroIndexes.add(r);
                if(c<=k)
                {
                    maxLen=Math.max(maxLen, r-l+1);
                    r++;
                }
                else
                {
                    l=ZeroIndexes.poll()+1;
                    c-=1;
                    maxLen=Math.max(maxLen, r-l+1);
                    r++;
                }
            }
        }
        return maxLen;
    }
}