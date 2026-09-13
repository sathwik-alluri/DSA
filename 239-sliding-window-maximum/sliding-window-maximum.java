class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n=nums.length;
        Deque<Integer> dq=new LinkedList<>();
        int ans[]=new int[n-k+1];
        int a=0;

        for(int i=0;i<n;i++)
        {
            while(dq.isEmpty()==false && dq.peekFirst() <= i-k)
                dq.pollFirst();

            while(dq.isEmpty()==false && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if(i >= k-1)
            {
                ans[a]=nums[dq.peekFirst()];
                a++;
            } 
        }
        return ans;
    }
}