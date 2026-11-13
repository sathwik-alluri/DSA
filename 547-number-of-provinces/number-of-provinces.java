class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        int V=isConnected.length;
        int vis[]=new int[V];
        int c=0;

        for(int i=0;i<V;i++)
        {
            if(vis[i] == 0)
            {
                 BFS(V, isConnected, i, vis);
                 c++;
            }
        }
        return c;
    }

    void BFS(int V, int[][] isConnected, int start, int[] vis)
    {
        Queue<Integer> q=new LinkedList<>();
        
        vis[start]=1;
        q.add(start);
        
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(int i=0;i<V; i++)
            {
                if(isConnected[curr][i]==1 && vis[i] != 1)
                {
                    q.add(i);
                    vis[i] = 1;
                }
            }
        }
    }
}