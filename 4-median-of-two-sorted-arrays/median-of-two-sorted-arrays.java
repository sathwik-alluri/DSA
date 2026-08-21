class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        int m=nums2.length;

        ArrayList<Integer> merge=new ArrayList<>();
        int l=0;
        int r=0;
        int mid=(n+m)/2;
        while(l<n && r<m)
        {
            if(nums1[l] <= nums2[r])
            {
                merge.add(nums1[l]);
                l++;
            }
            else
            {
                merge.add(nums2[r]);
                r++;
            }
        }
        while(l<n)
        {
            merge.add(nums1[l]);
            l++;
        }
        while(r<m)
        {
            merge.add(nums2[r]);
            r++;
        }
        
        if((n+m)%2!=0)
        {
            return (double)merge.get(mid);
        }
        return (double)(merge.get(mid) + merge.get(mid-1))/2;
    }
}