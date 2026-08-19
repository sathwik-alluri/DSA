class Solution {
    public int minEatingSpeed(int[] piles, int h)    //TC: O(log (max element)) * O(n) 
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

            if(hours > h)    //Koko is taking more hours than allowed. So it is slow. We need to increase the speed.
                l=mid+1;

            else    //Eating faster. SO to let it eat slowly. We have to reduce the speed.
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