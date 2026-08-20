class Solution {
    public int splitArray(int[] arr, int k) 
    {
        int n=arr.length;
        if(n<k)
            return -1;
        
        int max=arr[0];
        long sum=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(arr[i], max);
            sum+=arr[i];
        }
        
        long l=max;
        long r=sum;
        long ans=-1;
        while(l<=r)
        {
            long mid=(l+r)/2;
            long sunarrays = helper(arr, mid, k);
            
            if(sunarrays <= k)
            {
                ans=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return (int)ans; 
    }
    public long helper(int[] arr, long pages, int k) 
    {
        int n=arr.length;
        int sunarrays=1;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            if(sum + arr[i] > pages)
            {
                sum=arr[i];
                sunarrays+=1;
            }
            else
                sum+=arr[i];
        }
        return sunarrays;
    }
}