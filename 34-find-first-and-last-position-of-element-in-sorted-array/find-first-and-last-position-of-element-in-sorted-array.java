class Solution {
    public int[] searchRange(int[] arr, int x) 
    {
        int first=firstOccurance(arr,x);
        int last=lastOccurance(arr,x);
        int ans[]={first,last};
        return ans;
    }
    int firstOccurance(int[] arr, int x)
    {
        int l=0;
        int r=arr.length-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==x)
            {
                ans=mid;
                r=mid-1;  
            }
            else if(arr[mid]>x)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }

    int lastOccurance(int[] arr, int x)
    {
        int l=0;
        int r=arr.length-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==x)
            {
                ans=mid;
                l=mid+1; 
            }
            else if(arr[mid]>x)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
}