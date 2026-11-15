class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int V=graph.length;
        int vis[]=new int[V];
        Arrays.fill(vis, -1);

        for(int i=0;i<V;i++)
        {
            if(vis[i] == -1)
            {
                if(BFS(graph, i, vis) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean BFS(int[][] graph, int start, int[] vis)
    {
        Queue<Integer> q=new LinkedList<>();

        vis[start]=0;
        q.add(start);

        while(!q.isEmpty())
        {
            int curr=q.poll();

            for(int i=0;i<graph[curr].length;i++)
            {
                int neighbour = graph[curr][i];
                if(vis[neighbour] == -1)
                {
                    vis[neighbour] = 1-vis[curr];
                    q.add(neighbour);
                }
                else if(vis[neighbour] == vis[curr])
                {
                    return false;
                }
            }
        }
        return true;
    }
}