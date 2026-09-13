class Solution {
    public int maximalRectangle(char[][] matrix) 
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
        int arr[]=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j] == '0')
                    arr[j]=0;
                else
                    arr[j]=arr[j]+1;
            }
            int area=largestRectangleArea(arr);
            ans=Math.max(ans, area);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();    //TC:O(2n) and SC:O(n)
        int ans=0;
        for(int i=0;i<n;i++)
        {
            while(st.isEmpty()==false && heights[st.peek()] > heights[i])
            {
                int curr=heights[st.pop()];
                int prevSmaller=-1;
                if(st.isEmpty() == false)
                    prevSmaller=st.peek();
                int nextSmaller=i;

                int width=nextSmaller-prevSmaller-1;
                int area=width*curr;
                ans=Math.max(ans, area);
            }
            st.push(i);
        }
        while(st.isEmpty()==false)
        {
            int curr=heights[st.pop()];
            int prevSmaller=-1;
            if(st.isEmpty() == false)
                prevSmaller=st.peek();
            int nextSmaller=n;

            int width=nextSmaller-prevSmaller-1;
            int area=width*curr;
            ans=Math.max(ans, area);
        }
        return ans;
    }
}