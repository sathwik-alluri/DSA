class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        Stack<Integer> st=new Stack<>();   //TC: O(n)  
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=2*n-1;i>=0;i--)
        {
            int ind=i%n;
            while(st.isEmpty()==false && nums[ind] >= st.peek())
                st.pop();

            if(i< n)
            {
                if(st.isEmpty())
                    ans[i] = -1;

                else
                    ans[i] = st.peek(); 
            }
            st.push(nums[ind]); 
        }
        return ans; 
    }
}