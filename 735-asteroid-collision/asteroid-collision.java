class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            int curr=asteroids[i];
            int same=0;
            while(st.isEmpty() == false)
            {
                if((st.peek() > 0 && curr<0) && -1*curr >= st.peek())
                {
                    if(-1*curr == st.peek())
                    {
                        st.pop();
                        same=1;
                        break;
                    }
                    st.pop();
                }
                else
                    break;
            }
            if(same == 1)
                continue;
            else if(st.isEmpty() || (st.peek() > 0 && curr>0) || (st.peek() < 0 && curr<0) || (st.peek() < 0 && curr>0))
                st.push(curr);
        }

        int ans[]=new int[st.size()];
        int i=st.size()-1;
        while(st.isEmpty() == false)
        {
            ans[i]=st.pop();
            i--;
        }
        return ans;
    }
}