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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int n=image.length;
        int m=image[0].length;
        Queue<Pair> q =new LinkedList<>();
        
        int original =image[sr][sc];
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

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
                        image[neighbourRow][neighbourCol] == original && image[neighbourRow][neighbourCol] != color)
                {
                    image[neighbourRow][neighbourCol] = color;
                    q.add(new Pair(neighbourRow, neighbourCol));
                }
            }
        }
        return image;
    }
}