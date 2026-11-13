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
    public int numIslands(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
                int vis[][]=new int[n][m];
                int c=0;

                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<m; j++)
                    {
                        if(grid[i][j] == '1' && vis[i][j] == 0)
                        {
                            BFS(grid, i, j, vis);
                            c++;
                        }
                    }
                }
                return c;   
    }

    void BFS(char[][] grid, int r, int c, int[][] vis)
    {
           Queue<Pair> q=new LinkedList<>();

           vis[r][c] = 1;
           q.add(new Pair(r, c));
           
           int n=grid.length;
            int m=grid[0].length;

           while(!q.isEmpty())
           {
               Pair curr=q.poll();
               int row=curr.row;
               int col=curr.col;

               int delrow[] = {-1, 0, 1, 0};
               int delcol[] = {0, 1, 0, -1};
               for(int i = 0; i < 4; i++)
                {
                    int neighbourRow = row + delrow[i];
                    int neighbourCol = col + delcol[i];

                    if(neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m &&
                            grid[neighbourRow][neighbourCol] == '1' &&
                                        vis[neighbourRow][neighbourCol] == 0)
                    {
                        vis[neighbourRow][neighbourCol] = 1;
                        q.add(new Pair(neighbourRow, neighbourCol));
                    }
                }
           }
       }
}