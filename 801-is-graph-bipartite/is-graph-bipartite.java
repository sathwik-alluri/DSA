class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        // int V=graph.length;
        // int vis[]=new int[V];
        // Arrays.fill(vis, -1);

        // for(int i=0;i<V;i++)
        // {
        //     if(vis[i] == -1)
        //     {
        //         if(BFS(graph, i, vis) == false)
        //             return false;
        //     }
        // }
        // return true;


        int V=graph.length;
        int vis[]=new int[V];
        Arrays.fill(vis, -1);

        for(int i=0;i<V;i++)
        {
            if(vis[i] == -1)
            {
                if(DFS(graph, i, vis, 1) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean DFS(int[][] graph, int start, int[] vis, int parentColor)    //O(V + 2E)
    {
        vis[start]=1-parentColor;

        for(int i=0;i<graph[start].length;i++)
        {
            int neighbour = graph[start][i];
            if(vis[neighbour] == -1)
            {
                if(DFS(graph, neighbour, vis, vis[start]) == false)
                    return false;
            }
            else if(vis[neighbour] == vis[start])
            {
                return false;
            }
        }
        return true;
    }

    public boolean BFS(int[][] graph, int start, int[] vis)    //O(V + 2E)
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