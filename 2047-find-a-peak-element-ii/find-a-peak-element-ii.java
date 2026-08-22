class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;
        int ans[]={0,0};

        int l=0;
        int r=m-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            int row= maxElementRow(mat, mid);   //To fid the max element in this column

            int left=-1;
            int right=-1;
            if(mid-1>=0)
                left=mat[row][mid-1];
            if(mid+1 < m)
                right=mat[row][mid+1];
            
            if(mat[row][mid] > left && mat[row][mid] > right)
            {
                ans[0]=row;
                ans[1]=mid;
                return ans;
            }

            if(mat[row][mid] < left)
                r=mid-1;
            else
                l=mid+1;
        }
        return ans;
    }
    public int maxElementRow(int[][] mat, int col) 
    {
        int n=mat.length;
        int maxEleRow=0;
        int maxEle=-1;
        for(int i=0;i<n;i++)
        {
            if(mat[i][col] > maxEle)
            {
                maxEle=mat[i][col];
                maxEleRow=i;
            }
        }
        return maxEleRow;
    }
}