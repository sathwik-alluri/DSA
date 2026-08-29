class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;

    int totalSum = 0;

    for(int x : cardPoints)
        totalSum += x;

    int windowSize = n - k;

    int l = 0;
    int r = 0;
    int windowSum = 0;
    int minSum = Integer.MAX_VALUE;

    while(r < n)
    {
        windowSum += cardPoints[r];

        // Keep window size = n-k
        if(r - l + 1 > windowSize)
        {
            windowSum -= cardPoints[l];
            l++;
        }

        if(r - l + 1 == windowSize)
        {
            minSum = Math.min(minSum, windowSum);
        }

        r++;
    }

    return totalSum - minSum;

        // int n=cardPoints.length;
        // int maxSum=0;
        // int lsum=0;
        // int rsum=0;
        // for(int i=0;i<k;i++)
        // {
        //     lsum+=cardPoints[i];
        // }
        // maxSum=lsum;
        // int rind=n-1;
        // for(int i=k-1;i>=0;i--)
        // {
        //     lsum-=cardPoints[i];
        //     rsum+=cardPoints[rind];
        //     rind--;
        //     maxSum=Math.max(maxSum, lsum + rsum);
        // }
        // return maxSum;
    }
}