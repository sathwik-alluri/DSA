class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int n=weights.length;
        int sum=0;
        int max=weights[0];
        for(int i=0;i<n;i++)
        {
            max=Math.max(weights[i], max);
            sum+=weights[i];
        }

        //[0, sum]
        int l=max;
        int r=sum;
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            int possibleDays = helper(weights, mid, n);

            if(possibleDays <= days)
            {
                ans=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return ans;
    }
    public int helper(int[] weights, int weight, int n) 
    {
        int days=1;
        int sum=0;
        int i=0;
        for(i=0;i<n;i++)
        {
            if(sum+weights[i] > weight)
            {
                days+=1;
                sum=weights[i];
            }
            else
                sum+=weights[i];
        }
        return days;
    }
}