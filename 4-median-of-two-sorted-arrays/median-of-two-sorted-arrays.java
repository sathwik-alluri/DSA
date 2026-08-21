class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n1=nums1.length;  //TC: O(min(log n, log m))
        int n2=nums2.length;
        if(n1 > n2)
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l=0;
        int r=n1;
        int left=(n1+n2+1)/2;
        while(l<=r)
        {
            int mid1=(l+r)/2;      //Number of elements to be taken from ledt array
            int mid2= left - mid1; // Number of remaining req in nums2 to be part of left

            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;

            if(mid1 < n1)
                r1=nums1[mid1];
            if(mid2 < n2)
                r2=nums2[mid2];
            
            if(mid1-1>=0)
                l1=nums1[mid1-1];
            if(mid2-1>=0)
                l2=nums2[mid2-1];

            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2 != 0)            //Odd length
                {
                    return Math.max(l1, l2);
                }
                else                          //Even length
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2))/2;
            }

            else if(l1 > r2)
                r=mid1-1;
            
            else           //if(l2 < r1)
                l=mid1+1;
        }
        return 0;



        // int n=nums1.length;         //TC: O(n+m)    //SC:O(n+m)
        // int m=nums2.length;
        // ArrayList<Integer> merge=new ArrayList<>();
        // int l=0;
        // int r=0;
        // int mid=(n+m)/2;
        // while(l<n && r<m)
        // {
        //     if(nums1[l] <= nums2[r])
        //     {
        //         merge.add(nums1[l]);
        //         l++;
        //     }
        //     else
        //     {
        //         merge.add(nums2[r]);
        //         r++;
        //     }
        // }
        // while(l<n)
        // {
        //     merge.add(nums1[l]);
        //     l++;
        // }
        // while(r<m)
        // {
        //     merge.add(nums2[r]);
        //     r++;
        // }
        
        // if((n+m)%2!=0)
        // {
        //     return (double)merge.get(mid);
        // }
        // return (double)(merge.get(mid) + merge.get(mid-1))/2;
    }
}