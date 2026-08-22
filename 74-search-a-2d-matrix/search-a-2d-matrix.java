class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n=matrix.length;
        int m=matrix[0].length;

    //     for(int i=0;i<n;i++)     //TC: O(n) + O(logm)
    //     {
    //         if(matrix[i][0] <= target && target <= matrix[i][m-1])
    //         {
    //             int l=0;
    //             int r=m-1;
    //             while(l<=r)
    //             {
    //                 int mid=(l+r)/2;
    //                 if(matrix[i][mid] == target)
    //                     return true;

    //                 if(matrix[i][mid] < target)
    //                     l=mid+1;
    //                 else
    //                     r=mid-1;
    //             }
    //         }
    //     }
    //     return false;


        int l=0;            //TC: O(log nm)
        int r=n*m-1;
        while(l<=r)
        {
            int mid=(l+r)/2;

            int oRow=mid/m;
            int oCol=mid%m;

            if(matrix[oRow][oCol] == target)
                return true;

            if(matrix[oRow][oCol] < target)
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }
}