class Solution {
    public int minDays(int[] bloomDay, int m, int k) //TC: O(max(arr) - min(arr) + 1) * O(n)
    {
        int n=bloomDay.length;
        if(m*k > n)
            return -1;
        
        int max=bloomDay[0];
        int min=bloomDay[0];
        for(int i=0;i<n;i++)
        {
            max=Math.max(max, bloomDay[i]);
            min=Math.min(min, bloomDay[i]);
        }

        int l=min;
        int r=max;
        int ans=-1;
        while(l<=r)
        {
            int mid= (l+r)/2;

            int possiblebouquets=calculateBouquets(bloomDay, mid, k);

            if(possiblebouquets >= m)
            {
                ans=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return ans;
    }
    public int calculateBouquets(int[] bloomDay, int day, int k) 
    {
        int bc=0;
        int c=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] <= day)
            {
                c+=1;
                if(c==k)
                {
                    bc+=1;
                    c=0;
                }
            }
            else
            {
                c=0;
            }
        }
        return bc;
    }
}