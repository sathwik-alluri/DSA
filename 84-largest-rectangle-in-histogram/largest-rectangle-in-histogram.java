class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        int nse[]=nextSmallerElement(heights);
        int pse[]=previousSmallerElement(heights);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int w=nse[i]-pse[i]-1;
            int area=w*heights[i];

            ans=Math.max(ans, area);
        }
        return ans;
    }

    public int[] previousSmallerElement(int[] arr) 
    {
        int n=arr.length;
        int[] pse=new int[n];
        Arrays.fill(pse, -1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(st.isEmpty()==false && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
                pse[i]=st.peek();
            st.push(i);
        }
        return pse;
    }

    public int[] nextSmallerElement(int[] arr) 
    {
        int n=arr.length;
        int[] nse=new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(st.isEmpty()==false && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
                nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
}