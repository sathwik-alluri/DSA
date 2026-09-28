class Solution {
    public int longestConsecutive(int[] arr) 
    {
        // code here
        if(arr.length == 0)
            return 0;
        HashSet<Integer> h=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            h.add(arr[i]);
        }
        
        // int ans=1;     //This is Failing one Test case
        // for(int i=0;i<n;i++)
        // {
        //     int c=0;
        //     while(h.contains(arr[i] - c))
        //     {
        //         c++;
        //         if(c > ans)
        //             ans=c;
        //     }
        // }
        // return ans;
        
        int ans=1;
        for(int i=0;i<n;i++)
        {
            if (i>0 && arr[i] == arr[i - 1])
                continue; 

            if(!h.contains(arr[i] - 1))
            {
                int c=0;
                while(h.contains(arr[i] + c))
                {
                    c++;
                    ans=Math.max(ans, c);
                }
            }
        }
        return ans;
        
    }
}