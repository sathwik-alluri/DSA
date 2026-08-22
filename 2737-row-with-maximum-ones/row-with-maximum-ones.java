class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;

        int ans[]={0, 0};
        for(int i = 0; i < n; i++)
        {
            int ones = 0;
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 1)
                    ones++;
            }
            if(ones > ans[1])
            {
                ans[1] = ones;
                ans[0] = i;
            }
        }
        return ans;
    }
}