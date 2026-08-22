class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n=matrix.length;
        int m=matrix[0].length; //TC: O(log mn)

        int l=0;
        int r=m-1;
        while(l<n && r>=0)
        {
            if(matrix[l][r] == target)
                return true;
            
            if(matrix[l][r] < target)  //If current value < target, We need a larger value.we will move down
                l=l+1;

            else         //If curr value > target. It will be on left side. We will stay at same row. and we will reduce column value  
                r=r-1;
        }
        return false;
    }
}