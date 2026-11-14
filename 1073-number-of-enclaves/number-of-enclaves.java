class Pair
{
    int row;
    int col;
    Pair(int r, int c)
    {
        row=r;
        col=c;
    }
}
class Solution {
    public int numEnclaves(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q =new LinkedList<>();

        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i==0 || i==n-1 || j==0 || j==m-1) && grid[i][j] == 1)
                {
                    q.add(new Pair(i, j));
                    vis[i][j]=1;
                }
            }
        }

        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;

            int delRow[]={-1, +1, 0, 0};
            int delCol[]={0, 0, -1, +1};

            for(int i=0;i<4;i++)
            {
                int neighbourRow=row+delRow[i];
                int neighbourCol=col+delCol[i];

                if(neighbourRow>=0 && neighbourRow<n && neighbourCol>=0 && neighbourCol<m && 
                        grid[neighbourRow][neighbourCol] == 1 && vis[neighbourRow][neighbourCol] == 0)
                {
                    vis[neighbourRow][neighbourCol] = 1;
                    q.add(new Pair(neighbourRow, neighbourCol));
                }
            }
        }
        
        int lands=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1 && vis[i][j] == 0)
                {
                    lands++;
                }
            }
        }
        return lands;
    }
}