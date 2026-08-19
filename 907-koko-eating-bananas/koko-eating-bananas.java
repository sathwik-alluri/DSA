class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n=piles.length;
        int maxPile=piles[0];
        for(int i=0;i<n;i++)
        {
            maxPile=Math.max(maxPile, piles[i]);
        }

        int l=1;
        int r=maxPile;
        int ans = maxPile;
        while(l<=r)
        {
            int mid=(l+r)/2;
            long hours=calculateHours(piles, mid);

            if(hours > h)
                l=mid+1;

            else
            {
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }
    public long calculateHours(int[] piles, int k) 
    {
        long hours=0;
        for(int bananas: piles)
        {
            // hours += (bananas + k - 1)/k;    
            hours += (long) Math.ceil((double) bananas/k);
        }
        return hours;
    }
}