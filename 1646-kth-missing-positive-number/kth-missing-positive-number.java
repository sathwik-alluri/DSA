class Solution {
    public int findKthPositive(int[] arr, int k) 
    {
        // int n=arr.length;          TC:O(n)
        // for(int i=0; i<n;i++)
        // {
        //     if(arr[i] <= k)
        //         k++;
        //     else
        //         break;
        // }
        // return k;

        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<=r)
        {
            int mid=(l+r)/2;

            int missing=arr[mid] - (mid+1);

            if(missing <k)
                l=mid+1;
            else
                r=mid-1; 
        }
        //return r+1+k;    //return l+k;

        //Now the answer is Actual value to be present at arr[high]+more
        if(r==-1)
        {
            return k;
        }
        int missingAtR = arr[r]-(r+1); 
        int more = k-missingAtR;
        return arr[r]+more;
    }
}