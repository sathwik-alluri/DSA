class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> hm=new HashMap<>();
        int n=nums2.length;
        for(int i=n-1;i>=0;i--)
        {
            while(st.isEmpty()==false && nums2[i] >= st.peek())
                st.pop();
            if(st.isEmpty())
                hm.put(nums2[i], -1);
            else
              hm.put(nums2[i], st.peek()); 
            st.push(nums2[i]); 
        }
        
        n=nums1.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
    }
}