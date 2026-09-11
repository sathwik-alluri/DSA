class Solution {
    public int trap(int[] height) 
    {
        // int n = height.length;
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];

        // // Build prefix maximum
        // leftMax[0] = height[0];
        // for (int i = 1; i < n; i++) {
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        // }
        // // Build suffix maximum
        // rightMax[n - 1] = height[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        // }

        // // Calculate trapped water
        // int water = 0;
        // for (int i = 0; i < n; i++) {
        //     water += Math.min(leftMax[i], rightMax[i]) - height[i];
        // }
        // return water;



        // int n = height.length;
        // Stack<Integer> st=new Stack<>();
        // int water=0;
        // for(int i=0;i<n;i++)
        // {
        //     while(!st.isEmpty() && height[st.peek()] < height[i])
        //     {
        //         int current=height[st.pop()];
        //         if(!st.isEmpty())
        //         {
        //             int left=st.peek();
        //             int right=i;

        //             int width=(right-left)-1;

        //             int w=Math.min(height[left], height[right])-current;

        //             water+=width*w;
        //         }
        //     }
        //     st.push(i);
        // }
        // return water;

        
        int n=height.length;     //TC: O(n) and SC: O(1)
        int l=0;
        int r=n-1;
        int leftmax=0;
        int rightmax=0;
        int water=0;
        while(l<=r)
        {
            if(height[l] <= height[r])   //Left is smaller. SO this might be an right wall.
                                    //So we will process left side.
            {
                if(leftmax <= height[l])   //It it is the highest wall. We cant store water on this wall.
                {
                    leftmax=height[l];
                }
                else             //The height difference is the water we can share
                {
                    int heightDiff=leftmax - height[l];
                    water+=heightDiff;
                }
                l++;
            }
            else
            {
                if(rightmax <= height[r])
                {
                    rightmax=height[r];
                }
                else
                {
                    int heightDiff=rightmax - height[r];
                    water+=heightDiff;
                }
                r--;
            }           
        }
        return water;
    }
}