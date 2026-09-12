class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        // int n=asteroids.length;
        // Stack<Integer> st=new Stack<>();

        // for(int i=0;i<n;i++)
        // {
        //     int curr=asteroids[i];
        //     int same=0;
        //     while(st.isEmpty() == false)
        //     {
        //         if((st.peek() > 0 && curr<0) && -1*curr >= st.peek())
        //         {
        //             if(-1*curr == st.peek())
        //             {
        //                 st.pop();
        //                 same=1;
        //                 break;
        //             }
        //             st.pop();
        //         }
        //         else
        //             break;
        //     }
        //     if(same == 1)
        //         continue;
        //     else if(st.isEmpty() || (st.peek() > 0 && curr>0) || (st.peek() < 0 && curr<0) || (st.peek() < 0 && curr>0))
        //         st.push(curr);
        // }

        // int ans[]=new int[st.size()];
        // int i=st.size()-1;
        // while(st.isEmpty() == false)
        // {
        //     ans[i]=st.pop();
        //     i--;
        // }
        // return ans;


        int n=asteroids.length;        //TC:O(2n) and SC:O(n)
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            int curr=asteroids[i];
            if(curr > 0)
                st.push(curr);
            
            else
            {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(curr))
                    // Here the samaller one will explode amond pos and Neg ones
                    st.pop();
                
                if(!st.isEmpty() && st.peek()>0 && st.peek() == Math.abs(curr))
                    //If both are same size, then both will explode
                    st.pop();

                else if(st.isEmpty() || st.peek() < 0)     //There may be a change the neg aestrod may explode all positive aestroids. Then we need to add that to the Stack. Also when the peek element is an neg aesroud.
                    st.push(curr);
            }      
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